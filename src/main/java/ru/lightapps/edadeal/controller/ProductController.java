package ru.lightapps.edadeal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.lightapps.edadeal.dto.SelectForm;
import ru.lightapps.edadeal.entity.Product;
import ru.lightapps.edadeal.entity.Segment;
import ru.lightapps.edadeal.entity.Shop;
import ru.lightapps.edadeal.service.ProductService;
import ru.lightapps.edadeal.service.SegmentService;
import ru.lightapps.edadeal.service.ShopService;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private SegmentService segmentService;
    @Autowired
    private ShopService shopService;

    @RequestMapping("/product")
    public String showAllProducts(@ModelAttribute("segment") int segment, @ModelAttribute("shop") int shop, Model model) {
        Segment seg = segmentService.getSegment(segment);
        Shop sh = shopService.getShop(shop);
        System.out.println("Seg = " + seg);
        List<Product> allProducts = productService.getAllProductsBySegmentAndShop(seg, sh);
        model.addAttribute("allProducts", allProducts);
        model.addAttribute("seg", seg);
        return "view-products";
    }

    @RequestMapping("/product-request")
    public String requestProduct(@RequestParam("segmentId") int segmentId, @RequestParam("shopId") int shopId, Model model) {
        Segment segment = segmentService.getSegment(segmentId);
        Shop shop = shopService.getShop(shopId);
        productService.parseProductsBySegmentAndRetailer(segment, shop);
        model.addAttribute("segment", segmentId);
        model.addAttribute("shop", shopId);
        return "redirect:/product";
    }

    @RequestMapping("/")
    public String showSegments(Model model) {
        List<Segment> allSegments = segmentService.getAllSegments();
        List<Shop> allShops = shopService.getAllShops();
        model.addAttribute("selectForm", new SelectForm());
        model.addAttribute("segments", allSegments);
        model.addAttribute("shops", allShops);
        return "select-category";
    }
}
