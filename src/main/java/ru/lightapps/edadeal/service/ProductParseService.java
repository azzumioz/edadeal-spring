package ru.lightapps.edadeal.service;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.lightapps.edadeal.dao.SegmentDAO;
import ru.lightapps.edadeal.entity.Product;
import ru.lightapps.edadeal.entity.Segment;
import ru.lightapps.edadeal.entity.Shop;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ProductParseService {
    private static final Logger log = LoggerFactory.getLogger(ProductParseService.class);

    @Autowired
    private SegmentDAO segmentDAO;

    @Value("${app.url}")
    private String urlLink;

    @Value("${app.city}")
    private String city;

    @Value("${chromeOptions.useragent}")
    private String userAgent;

    @Value("${chrome.driver.path}")
    private String chromeDriverPath;

    @Value("${chrome.dimension.width}")
    private int dimensionWidth;

    @Value("${chrome.dimension.height}")
    private int dimensionHeight;

    @Value("${chrome.driver.timeout}")
    private int timeout;

    @Value("${chrome.hidden}")
    private boolean isHidden;

    @Value("${parse.page.count}")
    private int pageParseCount;

    public List<Product> parse(Segment segment, Shop shop) {

        String url;
        LocalDateTime dateTime = LocalDateTime.now();
        List<Product> list = new ArrayList<>();

        ChromeOptions chromeOptions = new ChromeOptions();
        if (isHidden) {
            chromeOptions.addArguments("headless");
        }
        chromeOptions.addArguments("general.useragent.override", userAgent);
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        WebDriver driver = new ChromeDriver(chromeOptions);
        Dimension dm = new Dimension(dimensionWidth, dimensionHeight);
        driver.manage().window().setSize(dm);
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);

        for (int i = 1; i <= pageParseCount; i++) {
            url = urlLink + city +  "/retailers/" + shop.getValue() + "?page=" + i + "&segment=" + segment.getValue();
            log.info("\nParse url: {}", url);
            driver.get(url);

            List<WebElement> productInfo = driver.findElements(By.className("b-offer__root"));
            for (WebElement product : productInfo) {

                String description = "";
                try {
                    description = product.findElement(By.className("b-offer__description")).getText();
                } catch (Exception e) {
                    log.info("description not found");
                }

                BigDecimal priceNew = new BigDecimal(0);
                try {
                    priceNew = parseToInt(product.findElement(By.className("b-offer__price-new")).getAttribute("title"));
                } catch (Exception e) {
                    log.info("priceNew not found");
                }

                BigDecimal priceOld = new BigDecimal(0);
                try {
                    priceOld = parseToInt(product.findElement(By.className("b-offer__price-old")).getAttribute("title"));
                } catch (Exception e) {
                    log.info("priceOld not found");
                }

                String magazine = "";
                try {
                    magazine = product.findElement(By.className("b-offer__retailer-icon")).getAttribute("title");
                } catch (Exception e) {
                    log.info("magazine not found");
                }

                String discountDate = "";
                try {
                    discountDate = product.findElement(By.className("b-offer__dates")).getText();
                } catch (Exception e) {
                    log.info("discountDate not found");
                }

                String discount = "";
                try {
                    discount = product.findElement(By.className("b-offer__badge")).getText();
                } catch (Exception e) {
                    log.info("discount not found");
                }

                String quantity = "";
                try {
                    quantity = product.findElement(By.className("b-offer__quantity")).getText();
                } catch (Exception e) {
                    log.info("quantity not found");
                }
                Product newProduct = new Product();
                newProduct.setTitle(description);
                newProduct.setQuantity(quantity);
                newProduct.setPriceNew(priceNew);
                newProduct.setPriceOld(priceOld);
                newProduct.setDiscount(discount);
                newProduct.setDiscountDate(discountDate);
                newProduct.setDate(dateTime);
                newProduct.setSegment(segment);
                newProduct.setShop(shop);
                list.add(newProduct);
            }
        }

        driver.quit();
        return list;
    }



    private static BigDecimal parseToInt(String priceText) {
        String priceInt;
        Pattern pattern = Pattern.compile("\\d*,\\d*");
        Matcher matcher = pattern.matcher(priceText);
        if (matcher.find()) {
            priceInt = matcher.group(0).replace(",", ".");
        } else {
            priceInt = "0";
        }
        return new BigDecimal(priceInt);
    }

}
