/*     */ package de.hybris.platform.customerreview.jalo;
/*     */ 
/*     */ import de.hybris.platform.customerreview.constants.GeneratedCustomerReviewConstants.TC;
/*     */ import de.hybris.platform.jalo.GenericItem;
/*     */ import de.hybris.platform.jalo.Item;
/*     */ import de.hybris.platform.jalo.Item.AttributeMode;
/*     */ import de.hybris.platform.jalo.Item.ItemAttributeMap;
/*     */ import de.hybris.platform.jalo.JaloBusinessException;
/*     */ import de.hybris.platform.jalo.JaloInvalidParameterException;
/*     */ import de.hybris.platform.jalo.JaloSession;
/*     */ import de.hybris.platform.jalo.SessionContext;
/*     */ import de.hybris.platform.jalo.c2l.Language;
/*     */ import de.hybris.platform.jalo.enumeration.EnumerationValue;
/*     */ import de.hybris.platform.jalo.product.Product;
/*     */ import de.hybris.platform.jalo.type.ComposedType;
/*     */ import de.hybris.platform.jalo.user.User;
/*     */ import de.hybris.platform.util.BidirectionalOneToManyHandler;
/*     */ import java.util.Collections;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class GeneratedCustomerReview
/*     */   extends GenericItem
/*     */ {
/*     */   public static final String HEADLINE = "headline";
/*     */   public static final String COMMENT = "comment";
/*     */   public static final String RATING = "rating";
/*     */   public static final String BLOCKED = "blocked";
/*     */   public static final String ALIAS = "alias";
/*     */   public static final String APPROVALSTATUS = "approvalStatus";
/*     */   public static final String LANGUAGE = "language";
/*     */   public static final String USER = "user";
/*     */   public static final String PRODUCT = "product";
/*  65 */   protected static final BidirectionalOneToManyHandler<GeneratedCustomerReview> USERHANDLER = new BidirectionalOneToManyHandler(
/*  66 */     GeneratedCustomerReviewConstants.TC.CUSTOMERREVIEW, 
/*  67 */     false, 
/*  68 */     "user", 
/*  69 */     null, 
/*  70 */     false, 
/*  71 */     true, 
/*  72 */     0);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  77 */   protected static final BidirectionalOneToManyHandler<GeneratedCustomerReview> PRODUCTHANDLER = new BidirectionalOneToManyHandler(
/*  78 */     GeneratedCustomerReviewConstants.TC.CUSTOMERREVIEW, 
/*  79 */     false, 
/*  80 */     "product", 
/*  81 */     null, 
/*  82 */     false, 
/*  83 */     true, 
/*  84 */     0);
/*     */   protected static final Map<String, Item.AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
/*     */   
/*     */   static
/*     */   {
/*  89 */     Map<String, Item.AttributeMode> tmp = new HashMap();
/*  90 */     tmp.put("headline", Item.AttributeMode.INITIAL);
/*  91 */     tmp.put("comment", Item.AttributeMode.INITIAL);
/*  92 */     tmp.put("rating", Item.AttributeMode.INITIAL);
/*  93 */     tmp.put("blocked", Item.AttributeMode.INITIAL);
/*  94 */     tmp.put("alias", Item.AttributeMode.INITIAL);
/*  95 */     tmp.put("approvalStatus", Item.AttributeMode.INITIAL);
/*  96 */     tmp.put("language", Item.AttributeMode.INITIAL);
/*  97 */     tmp.put("user", Item.AttributeMode.INITIAL);
/*  98 */     tmp.put("product", Item.AttributeMode.INITIAL);
/*  99 */     DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
/*     */   }
/*     */   
/*     */   protected Map<String, Item.AttributeMode> getDefaultAttributeModes()
/*     */   {
/* 104 */     return DEFAULT_INITIAL_ATTRIBUTES;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAlias(SessionContext ctx)
/*     */   {
/* 113 */     return (String)getProperty(ctx, "alias");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getAlias()
/*     */   {
/* 122 */     return getAlias(getSession().getSessionContext());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAlias(SessionContext ctx, String value)
/*     */   {
/* 131 */     setProperty(ctx, "alias", value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAlias(String value)
/*     */   {
/* 140 */     setAlias(getSession().getSessionContext(), value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public EnumerationValue getApprovalStatus(SessionContext ctx)
/*     */   {
/* 149 */     return (EnumerationValue)getProperty(ctx, "approvalStatus");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public EnumerationValue getApprovalStatus()
/*     */   {
/* 158 */     return getApprovalStatus(getSession().getSessionContext());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setApprovalStatus(SessionContext ctx, EnumerationValue value)
/*     */   {
/* 167 */     setProperty(ctx, "approvalStatus", value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setApprovalStatus(EnumerationValue value)
/*     */   {
/* 176 */     setApprovalStatus(getSession().getSessionContext(), value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Boolean isBlocked(SessionContext ctx)
/*     */   {
/* 187 */     return (Boolean)getProperty(ctx, "blocked");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Boolean isBlocked()
/*     */   {
/* 198 */     return isBlocked(getSession().getSessionContext());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isBlockedAsPrimitive(SessionContext ctx)
/*     */   {
/* 209 */     Boolean value = isBlocked(ctx);
/* 210 */     return value != null ? value.booleanValue() : false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isBlockedAsPrimitive()
/*     */   {
/* 221 */     return isBlockedAsPrimitive(getSession().getSessionContext());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBlocked(SessionContext ctx, Boolean value)
/*     */   {
/* 232 */     setProperty(ctx, "blocked", value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBlocked(Boolean value)
/*     */   {
/* 243 */     setBlocked(getSession().getSessionContext(), value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBlocked(SessionContext ctx, boolean value)
/*     */   {
/* 254 */     setBlocked(ctx, Boolean.valueOf(value));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBlocked(boolean value)
/*     */   {
/* 265 */     setBlocked(getSession().getSessionContext(), value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getComment(SessionContext ctx)
/*     */   {
/* 274 */     return (String)getProperty(ctx, "comment");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getComment()
/*     */   {
/* 283 */     return getComment(getSession().getSessionContext());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setComment(SessionContext ctx, String value)
/*     */   {
/* 292 */     setProperty(ctx, "comment", value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setComment(String value)
/*     */   {
/* 301 */     setComment(getSession().getSessionContext(), value);
/*     */   }
/*     */   
/*     */   protected Item createItem(SessionContext ctx, ComposedType type, Item.ItemAttributeMap allAttributes)
/*     */     throws JaloBusinessException
/*     */   {
/* 307 */     USERHANDLER.newInstance(ctx, allAttributes);
/* 308 */     PRODUCTHANDLER.newInstance(ctx, allAttributes);
/* 309 */     return super.createItem(ctx, type, allAttributes);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getHeadline(SessionContext ctx)
/*     */   {
/* 318 */     return (String)getProperty(ctx, "headline");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getHeadline()
/*     */   {
/* 327 */     return getHeadline(getSession().getSessionContext());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setHeadline(SessionContext ctx, String value)
/*     */   {
/* 336 */     setProperty(ctx, "headline", value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setHeadline(String value)
/*     */   {
/* 345 */     setHeadline(getSession().getSessionContext(), value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Language getLanguage(SessionContext ctx)
/*     */   {
/* 354 */     return (Language)getProperty(ctx, "language");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Language getLanguage()
/*     */   {
/* 363 */     return getLanguage(getSession().getSessionContext());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLanguage(SessionContext ctx, Language value)
/*     */   {
/* 372 */     setProperty(ctx, "language", value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLanguage(Language value)
/*     */   {
/* 381 */     setLanguage(getSession().getSessionContext(), value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Product getProduct(SessionContext ctx)
/*     */   {
/* 390 */     return (Product)getProperty(ctx, "product");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Product getProduct()
/*     */   {
/* 399 */     return getProduct(getSession().getSessionContext());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void setProduct(SessionContext ctx, Product value)
/*     */   {
/* 409 */     if (ctx.getAttribute("core.types.creation.initial") != Boolean.TRUE)
/*     */     {
/* 411 */       throw new JaloInvalidParameterException("attribute 'product' is not changeable", 0);
/*     */     }
/* 413 */     PRODUCTHANDLER.addValue(ctx, value, this);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void setProduct(Product value)
/*     */   {
/* 422 */     setProduct(getSession().getSessionContext(), value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getRating(SessionContext ctx)
/*     */   {
/* 432 */     return (Double)getProperty(ctx, "rating");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getRating()
/*     */   {
/* 442 */     return getRating(getSession().getSessionContext());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getRatingAsPrimitive(SessionContext ctx)
/*     */   {
/* 452 */     Double value = getRating(ctx);
/* 453 */     return value != null ? value.doubleValue() : 0.0D;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getRatingAsPrimitive()
/*     */   {
/* 463 */     return getRatingAsPrimitive(getSession().getSessionContext());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRating(SessionContext ctx, Double value)
/*     */   {
/* 473 */     setProperty(ctx, "rating", value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRating(Double value)
/*     */   {
/* 483 */     setRating(getSession().getSessionContext(), value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRating(SessionContext ctx, double value)
/*     */   {
/* 493 */     setRating(ctx, Double.valueOf(value));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRating(double value)
/*     */   {
/* 503 */     setRating(getSession().getSessionContext(), value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public User getUser(SessionContext ctx)
/*     */   {
/* 512 */     return (User)getProperty(ctx, "user");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public User getUser()
/*     */   {
/* 521 */     return getUser(getSession().getSessionContext());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void setUser(SessionContext ctx, User value)
/*     */   {
/* 531 */     if (ctx.getAttribute("core.types.creation.initial") != Boolean.TRUE)
/*     */     {
/* 533 */       throw new JaloInvalidParameterException("attribute 'user' is not changeable", 0);
/*     */     }
/* 535 */     USERHANDLER.addValue(ctx, value, this);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void setUser(User value)
/*     */   {
/* 544 */     setUser(getSession().getSessionContext(), value);
/*     */   }
/*     */ }