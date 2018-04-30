/*     */ package de.hybris.platform.customerreview.jalo;
/*     */ 
/*     */ import de.hybris.platform.core.Constants.USER;
/*     */ import de.hybris.platform.customerreview.constants.GeneratedCustomerReviewConstants.TC;
/*     */ import de.hybris.platform.jalo.JaloSession;
/*     */ import de.hybris.platform.jalo.SearchResult;
/*     */ import de.hybris.platform.jalo.SessionContext;
/*     */ import de.hybris.platform.jalo.extension.ExtensionManager;
/*     */ import de.hybris.platform.jalo.flexiblesearch.FlexibleSearch;
/*     */ import de.hybris.platform.jalo.product.Product;
/*     */ import de.hybris.platform.jalo.type.TypeManager;
/*     */ import de.hybris.platform.jalo.user.User;
/*     */ import de.hybris.platform.jalo.user.UserGroup;
/*     */ import de.hybris.platform.jalo.user.UserManager;
/*     */ import de.hybris.platform.util.JspContext;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CustomerReviewManager
/*     */   extends GeneratedCustomerReviewManager
/*     */ {
/*  42 */   private static final Logger LOG = Logger.getLogger(CustomerReviewManager.class.getName());
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static CustomerReviewManager getInstance()
/*     */   {
/*  51 */     ExtensionManager extensionManager = JaloSession.getCurrentSession().getExtensionManager();
/*  52 */     return (CustomerReviewManager)extensionManager.getExtension("customerreview");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void createEssentialData(Map params, JspContext jspc)
/*     */   {
/*  70 */     TypeManager typeManager = getSession().getTypeManager();
/*  71 */     UserGroup customers = getSession().getUserManager().getUserGroupByGroupID(Constants.USER.CUSTOMER_USERGROUP);
/*     */     
/*  73 */     if (typeManager.getSearchRestriction(typeManager.getComposedType(CustomerReview.class), "CustomerReviewRestrictions") == null)
/*     */     {
/*  75 */       typeManager.createRestriction("CustomerReviewRestrictions", customers, 
/*  76 */         typeManager.getComposedType(CustomerReview.class), "{blocked} = 0 OR {blocked} IS NULL");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CustomerReview createCustomerReview(Double rating, String headline, String comment, User user, Product product)
/*     */   {
/*  99 */     Map<String, Object> params = new HashMap();
/* 100 */     params.put("comment", comment);
/* 101 */     params.put("headline", headline);
/* 102 */     params.put("rating", rating);
/* 103 */     params.put("user", user);
/* 104 */     params.put("product", product);
/* 105 */     return createCustomerReview(getSession().getSessionContext(), params);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getAverageRating(SessionContext ctx, Product item)
/*     */   {
/* 120 */     String query = "SELECT avg({rating}) FROM {" + GeneratedCustomerReviewConstants.TC.CUSTOMERREVIEW + 
/* 121 */       "} WHERE {" + "product" + "} = ?product";
/* 122 */     Map<String, Product> values = Collections.singletonMap("product", item);
/* 123 */     List<Double> result = FlexibleSearch.getInstance()
/* 124 */       .search(query, values, Collections.singletonList(Double.class), true, 
/* 125 */       true, 
/* 126 */       0, -1).getResult();
/* 127 */     return (Double)result.iterator().next();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getNumberOfReviews(SessionContext ctx, Product item)
/*     */   {
/* 144 */     String query = "SELECT count(*) FROM {" + GeneratedCustomerReviewConstants.TC.CUSTOMERREVIEW + "} WHERE {" + 
/* 145 */       "product" + "} = ?product";
/* 146 */     Map<String, Product> values = Collections.singletonMap("product", item);
/* 147 */     List<Integer> result = FlexibleSearch.getInstance()
/* 148 */       .search(query, values, Collections.singletonList(Integer.class), true, 
/* 149 */       true, 
/* 150 */       0, -1).getResult();
/* 151 */     return (Integer)result.iterator().next();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<CustomerReview> getAllReviews(Product item)
/*     */   {
/* 163 */     return getAllReviews(JaloSession.getCurrentSession().getSessionContext(), item);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<CustomerReview> getAllReviews(SessionContext ctx, Product item)
/*     */   {
/* 177 */     String query = "SELECT {" + CustomerReview.PK + "} FROM {" + GeneratedCustomerReviewConstants.TC.CUSTOMERREVIEW + "} WHERE {" + 
/* 178 */       "product" + "} = ?product ORDER BY {" + CustomerReview.CREATION_TIME + "} DESC";
/* 179 */     Map<String, Product> values = Collections.singletonMap("product", item);
/* 180 */     List<CustomerReview> result = FlexibleSearch.getInstance()
/* 181 */       .search(ctx, query, values, Collections.singletonList(CustomerReview.class), true, true, 0, -1).getResult();
/* 182 */     return result;
/*     */   }
/*     */ }