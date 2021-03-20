package ru.lightapps.edadeal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.lightapps.edadeal.entity.Product;
import ru.lightapps.edadeal.entity.Segment;
import ru.lightapps.edadeal.service.ProductService;
import ru.lightapps.edadeal.service.SegmentService;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private SegmentService segmentService;

    @RequestMapping("/product")
    public String showAllProducts(@ModelAttribute("segment") Segment segment, Model model) {
        List<Product> allProducts;
        Segment seg = segmentService.getSegment(segment.getId());
        allProducts = productService.getAllProductsBySegment(segment);
        model.addAttribute("allProducts", allProducts);
        model.addAttribute("seg", seg);
        return "view-products";
    }

    @RequestMapping("/product-request")
    public String requestProduct(@RequestParam("segmentId") int segmentId, Model model) {
        productService.requestProduct(segmentId);
        model.addAttribute("segmentId", segmentId);
        return "redirect:/product";
    }

    @RequestMapping("/")
    public String showSegments(Model model) {
        List<Segment> allSegments = segmentService.getAllSegments();
        model.addAttribute("allSegments", allSegments);
        model.addAttribute("segment", new Segment());
        return "select-category";
    }
}
