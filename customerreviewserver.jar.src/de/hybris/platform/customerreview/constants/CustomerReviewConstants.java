/*     */ package de.hybris.platform.customerreview.constants;
/*     */ 
/*     */ import de.hybris.platform.core.Registry;
/*     */ import de.hybris.platform.core.Tenant;
/*     */ import de.hybris.platform.util.Config;
/*     */ import de.hybris.platform.util.SingletonCreator.Creator;
/*     */ import de.hybris.platform.util.config.ConfigIntf;
/*     */ import de.hybris.platform.util.config.ConfigIntf.ConfigChangeListener;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CustomerReviewConstants
/*     */   extends GeneratedCustomerReviewConstants
/*     */ {
/*  36 */   private static final Logger LOG = Logger.getLogger(CustomerReviewConstants.class.getName());
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
/*     */   private final ConfigIntf config;
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
/*  63 */   public volatile double MINRATING = 0.0D;
/*     */   
/*     */ 
/*     */ 
/*  67 */   public volatile double MAXRATING = 5.0D;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private CustomerReviewConstants()
/*     */   {
/*  76 */     Tenant tenant = Registry.getCurrentTenantNoFallback();
/*  77 */     this.config = tenant.getConfig();
/*  78 */     this.MINRATING = getMinRating();
/*  79 */     this.MAXRATING = getMaxRating();
/*     */     
/*     */ 
/*     */ 
/*  83 */     this.config.registerConfigChangeListener(new ConfigIntf.ConfigChangeListener()
/*     */     {
/*     */ 
/*     */ 
/*     */       public void configChanged(String key, String value)
/*     */       {
/*     */ 
/*     */ 
/*  91 */         if (key.equals("customerreview.minimalrating"))
/*     */         {
/*  93 */           CustomerReviewConstants.this.MINRATING = CustomerReviewConstants.this.getMinRating();
/*     */         }
/*  95 */         else if (key.equals("customerreview.maximalrating"))
/*     */         {
/*  97 */           CustomerReviewConstants.this.MAXRATING = CustomerReviewConstants.this.getMaxRating();
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static CustomerReviewConstants getInstance()
/*     */   {
/* 110 */     (CustomerReviewConstants)Registry.getSingleton(new SingletonCreator.Creator()
/*     */     {
/* 112 */       private final String SINGLETON_CREATOR_ID = CustomerReviewConstants.class.getName().intern();
/*     */       
/*     */ 
/*     */       protected String getID()
/*     */       {
/* 117 */         return this.SINGLETON_CREATOR_ID;
/*     */       }
/*     */       
/*     */ 
/*     */       protected CustomerReviewConstants create()
/*     */       {
/* 123 */         return new CustomerReviewConstants(null);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private double getMaxRating()
/*     */   {
/* 133 */     double maxRating = 0.0D;
/*     */     try
/*     */     {
/* 136 */       maxRating = this.config.getDouble("customerreview.maximalrating", 5.0D);
/*     */     }
/*     */     catch (NumberFormatException localNumberFormatException)
/*     */     {
/* 140 */       LOG.error("The parameter \"customerreview.maximalrating\" has illegal format (" + 
/* 141 */         Config.getParameter("customerreview.maximalrating") + "), using default value: " + 5.0D);
/*     */     }
/* 143 */     return maxRating;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private double getMinRating()
/*     */   {
/* 151 */     double minRating = 0.0D;
/*     */     try
/*     */     {
/* 154 */       minRating = this.config.getDouble("customerreview.minimalrating", 0.0D);
/*     */     }
/*     */     catch (NumberFormatException localNumberFormatException)
/*     */     {
/* 158 */       LOG.error("The parameter \"customerreview.minimalrating\" has illegal format (" + 
/* 159 */         Config.getParameter("customerreview.minimalrating") + "), using default value: " + 0.0D);
/*     */     }
/* 161 */     return minRating;
/*     */   }
/*     */   
/*     */   public static class DEFAULTS
/*     */   {
/*     */     public static final double MINIMAL_RATING = 0.0D;
/*     */     public static final double MAXIMAL_RATING = 5.0D;
/*     */   }
/*     */   
/*     */   public static class KEYS
/*     */   {
/*     */     public static final String MINIMAL_RATING = "customerreview.minimalrating";
/*     */     public static final String MAXIMAL_RATING = "customerreview.maximalrating";
/*     */   }
/*     */ }