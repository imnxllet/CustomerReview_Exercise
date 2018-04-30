/*    */ package de.hybris.platform.customerreview.jalo;
/*    */ 
/*    */ import de.hybris.platform.customerreview.constants.CustomerReviewConstants;
/*    */ import de.hybris.platform.jalo.Item.ItemAttributeMap;
/*    */ import de.hybris.platform.jalo.JaloBusinessException;
/*    */ import de.hybris.platform.jalo.JaloInvalidParameterException;
/*    */ import de.hybris.platform.jalo.SessionContext;
/*    */ import de.hybris.platform.jalo.type.ComposedType;
/*    */ import de.hybris.platform.util.localization.Localization;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CustomerReview
/*    */   extends GeneratedCustomerReview
/*    */ {
/*    */   public CustomerReview createItem(SessionContext ctx, ComposedType type, Item.ItemAttributeMap allAttributes)
/*    */     throws JaloBusinessException
/*    */   {
/* 55 */     Set missing = new HashSet();
/* 56 */     checkMandatoryAttribute("product", allAttributes, missing);
/* 57 */     checkMandatoryAttribute("user", allAttributes, missing);
/* 58 */     checkMandatoryAttribute("rating", allAttributes, missing);
/* 59 */     if (!missing.isEmpty())
/*    */     {
/* 61 */       throw new JaloInvalidParameterException("missing " + missing + " for creating a new CustomerReview", 0);
/*    */     }
/* 63 */     return (CustomerReview)super.createItem(ctx, type, allAttributes);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setRating(SessionContext ctx, Double rating)
/*    */   {
/* 81 */     if (rating == null)
/*    */     {
/* 83 */       throw new JaloInvalidParameterException(Localization.getLocalizedString("error.customerreview.invalidrating", 
/*    */       
/* 85 */         new Object[] { "null", new Double(CustomerReviewConstants.getInstance().MINRATING), 
/* 86 */         new Double(CustomerReviewConstants.getInstance().MAXRATING) }), 0);
/*    */     }
/* 88 */     if ((rating.doubleValue() < CustomerReviewConstants.getInstance().MINRATING) || 
/* 89 */       (rating.doubleValue() > CustomerReviewConstants.getInstance().MAXRATING))
/*    */     {
/* 91 */       throw new JaloInvalidParameterException(Localization.getLocalizedString("error.customerreview.invalidrating", 
/*    */       
/* 93 */         new Object[] { rating, new Double(CustomerReviewConstants.getInstance().MINRATING), 
/* 94 */         new Double(CustomerReviewConstants.getInstance().MAXRATING) }), 0);
/*    */     }
/* 96 */     super.setRating(ctx, rating);
/*    */   }
/*    */ }