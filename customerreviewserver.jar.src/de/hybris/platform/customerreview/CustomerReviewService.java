package de.hybris.platform.customerreview;

import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.customerreview.model.CustomerReviewModel;
import java.util.List;

public abstract interface CustomerReviewService
{
  public abstract CustomerReviewModel createCustomerReview(Double paramDouble, String paramString1, String paramString2, UserModel paramUserModel, ProductModel paramProductModel);
  
  public abstract void updateCustomerReview(CustomerReviewModel paramCustomerReviewModel, UserModel paramUserModel, ProductModel paramProductModel);
  
  public abstract List<CustomerReviewModel> getAllReviews(ProductModel paramProductModel);
  
  public abstract Double getAverageRating(ProductModel paramProductModel);
  
  public abstract Integer getNumberOfReviews(ProductModel paramProductModel);
  
  public abstract List<CustomerReviewModel> getReviewsForProduct(ProductModel paramProductModel);
  
  public abstract List<CustomerReviewModel> getReviewsForProductAndLanguage(ProductModel paramProductModel, LanguageModel paramLanguageModel);
}


/* Location:              /Users/TJL4646/CustomerReview_Assignment/customerreviewserver.jar!/de/hybris/platform/customerreview/CustomerReviewService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */