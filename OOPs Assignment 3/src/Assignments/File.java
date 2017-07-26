package Assignments;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

class CsvProductList{
	Product[] products;
	int numOfProducts;
	CsvProductList(){
		products = new Product[100];
        String csvFile = "D:/GET2017Assignments/OOPs Assignment 3/src/csv/ProductList.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        	int count = 0;
        	line = br.readLine();
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] productDetails = line.split(cvsSplitBy);
                int productId = Integer.valueOf(productDetails[0].trim());
                String productName = productDetails[1].trim();
                double productPrice = Double.valueOf(productDetails[2].trim());
                Product product = new Product();
                product.setAttributes(productId, productName, productPrice);
                products[count++] = product;
            }
            numOfProducts = count;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
	
	Product[] getProducts(){
		return Arrays.copyOfRange(this.products, 0, this.numOfProducts);
	}
}

class CsvProductPromoList{
	ProductPromotion[] productPromoList;
	int numOfProductPromotion;
	CsvProductPromoList(){
		 productPromoList = new ProductPromotion[100];
        String csvFile = "D:/GET2017Assignments/OOPs Assignment 3/src/csv/ProductPromo.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        	int count = 0;
        	line = br.readLine();
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] productPromoDetails = line.split(cvsSplitBy);
                String productPromotionType = productPromoDetails[0].trim();
                double discountAmount = 0.00;
                double discountPercent = 0.00;
                if(productPromotionType.equals("ProductFixedAmountPromotion")){
                	discountAmount = Double.valueOf(productPromoDetails[1].trim());
                }else{
                	discountPercent = Double.valueOf(productPromoDetails[1].trim());
                }
                String[] productsCodeList = productPromoDetails[2].trim().split(";");
                int[] productCodes = new int[productsCodeList.length];
                for(int i=0;i<productCodes.length;i++){
                	productCodes[i] = Integer.valueOf(productsCodeList[i].trim());
                }
                ProductPromotion productPromotion = new ProductPromotion();
            	productPromotion.setAttributes(productCodes, productPromotionType, discountAmount, discountPercent);
            	productPromoList[count++] = productPromotion;
            }
            numOfProductPromotion = count;

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
	
	ProductPromotion[] getProductsPromotionList(){
		return Arrays.copyOfRange(this.productPromoList, 0, this.numOfProductPromotion);
	}

}

class CsvOrderPromoList{
	OrderPromotion[] orderPromoList;
	int numOfOrderPromotion;
	CsvOrderPromoList(){
		orderPromoList = new OrderPromotion[100];
        String csvFile = "D:/GET2017Assignments/OOPs Assignment 3/src/csv/OrderPromo.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        	int count = 0;
        	line = br.readLine();
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] orderDetails = line.split(cvsSplitBy);
                String orderPromotionType = orderDetails[0].trim();
                double discountAmount = 0.00;
                double discountPercent = 0.00;
                if(orderPromotionType.equals("OrderFixedAmountPromotion")){
                	discountAmount = Double.valueOf(orderDetails[1].trim());
                }else{
                	discountPercent = Double.valueOf(orderDetails[1].trim());
                }
                double threshold = Double.valueOf(orderDetails[2].trim());
                OrderPromotion orderPromotion = new OrderPromotion();
                orderPromotion.setAttributes(orderPromotionType, discountAmount, discountPercent, threshold);
                orderPromoList[count++] = orderPromotion;
            }
            numOfOrderPromotion = count;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
	
	OrderPromotion[] geOrderPromotionsList(){
		return Arrays.copyOfRange(this.orderPromoList, 0, this.numOfOrderPromotion);
	}

}