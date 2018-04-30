/*     */ package de.hybris.platform.customerreview.jalo;
/*     */ 
/*     */ import de.hybris.platform.core.Tenant;
/*     */ import de.hybris.platform.customerreview.constants.GeneratedCustomerReviewConstants.Attributes.User;
/*     */ import de.hybris.platform.customerreview.constants.GeneratedCustomerReviewConstants.TC;
/*     */ import de.hybris.platform.jalo.Item;
/*     */ import de.hybris.platform.jalo.Item.AttributeMode;
/*     */ import de.hybris.platform.jalo.JaloBusinessException;
/*     */ import de.hybris.platform.jalo.JaloConnection;
/*     */ import de.hybris.platform.jalo.JaloInvalidParameterException;
/*     */ import de.hybris.platform.jalo.JaloSession;
/*     */ import de.hybris.platform.jalo.JaloSystemException;
/*     */ import de.hybris.platform.jalo.SessionContext;
/*     */ import de.hybris.platform.jalo.extension.Extension;
/*     */ import de.hybris.platform.jalo.product.Product;
/*     */ import de.hybris.platform.jalo.type.ComposedType;
/*     */ import de.hybris.platform.jalo.type.JaloGenericCreationException;
/*     */ import de.hybris.platform.jalo.type.TypeManager;
/*     */ import de.hybris.platform.jalo.user.User;
/*     */ import de.hybris.platform.util.OneToManyHandler;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class GeneratedCustomerReviewManager
/*     */   extends Extension
/*     */ {
/*  50 */   protected static final OneToManyHandler<CustomerReview> REVIEWTOPRODUCTRELPRODUCTREVIEWSHANDLER = new OneToManyHandler(
/*  51 */     GeneratedCustomerReviewConstants.TC.CUSTOMERREVIEW, 
/*  52 */     true, 
/*  53 */     "product", 
/*  54 */     null, 
/*  55 */     false, 
/*  56 */     true, 
/*  57 */     0);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  62 */   protected static final OneToManyHandler<CustomerReview> REVIEWTOUSERRELCUSTOMERREVIEWSHANDLER = new OneToManyHandler(
/*  63 */     GeneratedCustomerReviewConstants.TC.CUSTOMERREVIEW, 
/*  64 */     false, 
/*  65 */     "user", 
/*  66 */     null, 
/*  67 */     false, 
/*  68 */     true, 
/*  69 */     0);
/*     */   protected static final Map<String, Map<String, Item.AttributeMode>> DEFAULT_INITIAL_ATTRIBUTES;
/*     */   
/*     */   static
/*     */   {
/*  74 */     Map<String, Map<String, Item.AttributeMode>> ttmp = new HashMap();
/*  75 */     DEFAULT_INITIAL_ATTRIBUTES = ttmp;
/*     */   }
/*     */   
/*     */   public Map<String, Item.AttributeMode> getDefaultAttributeModes(Class<? extends Item> itemClass)
/*     */   {
/*  80 */     Map<String, Item.AttributeMode> ret = new HashMap();
/*  81 */     Map<String, Item.AttributeMode> attr = (Map)DEFAULT_INITIAL_ATTRIBUTES.get(itemClass.getName());
/*  82 */     if (attr != null)
/*     */     {
/*  84 */       ret.putAll(attr);
/*     */     }
/*  86 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public abstract Double getAverageRating(SessionContext paramSessionContext, Product paramProduct);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getAverageRating(Product item)
/*     */   {
/* 101 */     return getAverageRating(getSession().getSessionContext(), item);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getAverageRatingAsPrimitive(SessionContext ctx, Product item)
/*     */   {
/* 110 */     Double value = getAverageRating(ctx, item);
/* 111 */     return value != null ? value.doubleValue() : 0.0D;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getAverageRatingAsPrimitive(Product item)
/*     */   {
/* 120 */     return getAverageRatingAsPrimitive(getSession().getSessionContext(), item);
/*     */   }
/*     */   
/*     */   public CustomerReview createCustomerReview(SessionContext ctx, Map attributeValues)
/*     */   {
/*     */     try
/*     */     {
/* 127 */       ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType(GeneratedCustomerReviewConstants.TC.CUSTOMERREVIEW);
/* 128 */       return (CustomerReview)type.newInstance(ctx, attributeValues);
/*     */     }
/*     */     catch (JaloGenericCreationException e)
/*     */     {
/* 132 */       Throwable cause = e.getCause();
/* 133 */       throw ((cause instanceof RuntimeException) ? 
/* 134 */         (RuntimeException)cause : 
/*     */         
/* 136 */         new JaloSystemException(cause, cause.getMessage(), e.getErrorCode()));
/*     */     }
/*     */     catch (JaloBusinessException e)
/*     */     {
/* 140 */       throw new JaloSystemException(e, "error creating CustomerReview : " + e.getMessage(), 0);
/*     */     }
/*     */   }
/*     */   
/*     */   public CustomerReview createCustomerReview(Map attributeValues)
/*     */   {
/* 146 */     return createCustomerReview(getSession().getSessionContext(), attributeValues);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Collection<CustomerReview> getCustomerReviews(SessionContext ctx, User item)
/*     */   {
/* 155 */     return REVIEWTOUSERRELCUSTOMERREVIEWSHANDLER.getValues(ctx, item);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Collection<CustomerReview> getCustomerReviews(User item)
/*     */   {
/* 164 */     return getCustomerReviews(getSession().getSessionContext(), item);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void setCustomerReviews(SessionContext ctx, User item, Collection<CustomerReview> value)
/*     */   {
/* 174 */     if (ctx.getAttribute("core.types.creation.initial") != Boolean.TRUE)
/*     */     {
/* 176 */       throw new JaloInvalidParameterException("attribute '" + GeneratedCustomerReviewConstants.Attributes.User.CUSTOMERREVIEWS + "' is not changeable", 0);
/*     */     }
/* 178 */     REVIEWTOUSERRELCUSTOMERREVIEWSHANDLER.setValues(ctx, item, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void setCustomerReviews(User item, Collection<CustomerReview> value)
/*     */   {
/* 187 */     setCustomerReviews(getSession().getSessionContext(), item, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void addToCustomerReviews(SessionContext ctx, User item, CustomerReview value)
/*     */   {
/* 197 */     if (ctx.getAttribute("core.types.creation.initial") != Boolean.TRUE)
/*     */     {
/* 199 */       throw new JaloInvalidParameterException("attribute '" + GeneratedCustomerReviewConstants.Attributes.User.CUSTOMERREVIEWS + "' is not changeable", 0);
/*     */     }
/* 201 */     REVIEWTOUSERRELCUSTOMERREVIEWSHANDLER.addValue(ctx, item, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void addToCustomerReviews(User item, CustomerReview value)
/*     */   {
/* 210 */     addToCustomerReviews(getSession().getSessionContext(), item, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void removeFromCustomerReviews(SessionContext ctx, User item, CustomerReview value)
/*     */   {
/* 220 */     if (ctx.getAttribute("core.types.creation.initial") != Boolean.TRUE)
/*     */     {
/* 222 */       throw new JaloInvalidParameterException("attribute '" + GeneratedCustomerReviewConstants.Attributes.User.CUSTOMERREVIEWS + "' is not changeable", 0);
/*     */     }
/* 224 */     REVIEWTOUSERRELCUSTOMERREVIEWSHANDLER.removeValue(ctx, item, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void removeFromCustomerReviews(User item, CustomerReview value)
/*     */   {
/* 233 */     removeFromCustomerReviews(getSession().getSessionContext(), item, value);
/*     */   }
/*     */   
/*     */ 
/*     */   public String getName()
/*     */   {
/* 239 */     return "customerreview";
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public abstract Integer getNumberOfReviews(SessionContext paramSessionContext, Product paramProduct);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getNumberOfReviews(Product item)
/*     */   {
/* 254 */     return getNumberOfReviews(getSession().getSessionContext(), item);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getNumberOfReviewsAsPrimitive(SessionContext ctx, Product item)
/*     */   {
/* 263 */     Integer value = getNumberOfReviews(ctx, item);
/* 264 */     return value != null ? value.intValue() : 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getNumberOfReviewsAsPrimitive(Product item)
/*     */   {
/* 273 */     return getNumberOfReviewsAsPrimitive(getSession().getSessionContext(), item);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Collection<CustomerReview> getProductReviews(SessionContext ctx, Product item)
/*     */   {
/* 282 */     return REVIEWTOPRODUCTRELPRODUCTREVIEWSHANDLER.getValues(ctx, item);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Collection<CustomerReview> getProductReviews(Product item)
/*     */   {
/* 291 */     return getProductReviews(getSession().getSessionContext(), item);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setProductReviews(SessionContext ctx, Product item, Collection<CustomerReview> value)
/*     */   {
/* 300 */     REVIEWTOPRODUCTRELPRODUCTREVIEWSHANDLER.setValues(ctx, item, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setProductReviews(Product item, Collection<CustomerReview> value)
/*     */   {
/* 309 */     setProductReviews(getSession().getSessionContext(), item, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addToProductReviews(SessionContext ctx, Product item, CustomerReview value)
/*     */   {
/* 318 */     REVIEWTOPRODUCTRELPRODUCTREVIEWSHANDLER.addValue(ctx, item, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addToProductReviews(Product item, CustomerReview value)
/*     */   {
/* 327 */     addToProductReviews(getSession().getSessionContext(), item, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void removeFromProductReviews(SessionContext ctx, Product item, CustomerReview value)
/*     */   {
/* 336 */     REVIEWTOPRODUCTRELPRODUCTREVIEWSHANDLER.removeValue(ctx, item, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void removeFromProductReviews(Product item, CustomerReview value)
/*     */   {
/* 345 */     removeFromProductReviews(getSession().getSessionContext(), item, value);
/*     */   }
/*     */ }