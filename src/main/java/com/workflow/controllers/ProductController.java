package com.workflow.controllers;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import com.workflow.domain.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/workflow")
@Api(value="workflow", description="Cucumber feature generator from Workflow")
public class ProductController {

//    @ApiOperation(value = "View a list of available products",response = Iterable.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successfully retrieved list"),
//            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
//    }
//    )
//    @RequestMapping(value = "/list", method= RequestMethod.GET, produces = "application/json")
//    public Iterable<Product> list(Model model){
//        Iterable<Product> productList = productService.listAllProducts();
//        return productList;
//    }
//    @ApiOperation(value = "Search a product with an ID",response = Product.class)
//    @RequestMapping(value = "/show/{id}", method= RequestMethod.GET, produces = "application/json")
//    public Product showProduct(@PathVariable Integer id, Model model){
//       Product product = productService.getProductById(id);
//        return product;
//    }

    @ApiOperation(value = "Add a workflow")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveProduct(@RequestBody Product product){
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_27);
        try {
            //Load template from source folder
            cfg.setDirectoryForTemplateLoading(new File("src/main/resources/"));

            // Build the data-model
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("description",product.getDescription());


            Template template = cfg.getTemplate("feature-file-generator.ftl");

            // File output
            Writer file = new FileWriter(new File("src/main/resources/features/workflow.feature"));
            template.process(data, file);
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return new ResponseEntity("Cucumber feature created successfully", HttpStatus.OK);
    }

//    @ApiOperation(value = "Update a product")
//    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
//    public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody Product product){
//        Product storedProduct = productService.getProductById(id);
//        storedProduct.setDescription(product.getDescription());
//        storedProduct.setImageUrl(product.getImageUrl());
//        storedProduct.setPrice(product.getPrice());
//        productService.saveProduct(storedProduct);
//        return new ResponseEntity("Product updated successfully", HttpStatus.OK);
//    }
//
//    @ApiOperation(value = "Delete a product")
//    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
//    public ResponseEntity delete(@PathVariable Integer id){
//        productService.deleteProduct(id);
//        return new ResponseEntity("Product deleted successfully", HttpStatus.OK);
//
//    }

}
