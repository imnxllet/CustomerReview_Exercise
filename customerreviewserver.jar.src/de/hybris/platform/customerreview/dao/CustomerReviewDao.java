package de.hybris.platform.customerreview.dao;

import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.customerreview.model.CustomerReviewModel;
import java.util.List;

public abstract interface CustomerReviewDao
{
  public abstract List<CustomerReviewModel> getReviewsForProduct(ProductModel paramProductModel);
  
  public abstract List<CustomerReviewModel> getReviewsForProductAndLanguage(ProductModel paramProductModel, LanguageModel paramLanguageModel);
}