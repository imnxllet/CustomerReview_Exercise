/*     */ package de.hybris.platform.customerreview.jalo;
/*     */ 
/*     */ import de.hybris.platform.customerreview.constants.CustomerReviewConstants;
/*     */ import de.hybris.platform.jalo.ConsistencyCheckException;
/*     */ import de.hybris.platform.jalo.JaloInvalidParameterException;
/*     */ import de.hybris.platform.jalo.JaloSession;
/*     */ import de.hybris.platform.jalo.SessionContext;
/*     */ import de.hybris.platform.jalo.product.Product;
/*     */ import de.hybris.platform.jalo.product.ProductManager;
/*     */ import de.hybris.platform.jalo.user.Customer;
/*     */ import de.hybris.platform.jalo.user.User;
/*     */ import de.hybris.platform.jalo.user.UserGroup;
/*     */ import de.hybris.platform.jalo.user.UserManager;
/*     */ import de.hybris.platform.testframework.HybrisJUnit4TransactionalTest;
/*     */ import de.hybris.platform.util.Config;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.junit.After;
/*     */ import org.junit.Assert;
/*     */ import org.junit.Before;
/*     */ import org.junit.Test;
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
/*     */ public class CustomerReviewTest
/*     */   extends HybrisJUnit4TransactionalTest
/*     */ {
/*  52 */   private static final Logger LOG = Logger.getLogger(CustomerReviewTest.class.getName());
/*     */   
/*     */ 
/*     */ 
/*     */   private static final String headline = "Test headline";
/*     */   
/*     */ 
/*     */ 
/*     */   private static final String comment = "Text text text";
/*     */   
/*     */ 
/*     */ 
/*  64 */   private final List<Customer> demoUsers = new ArrayList();
/*     */   
/*     */ 
/*     */ 
/*  68 */   private Product demoProduct = null;
/*     */   
/*     */ 
/*     */ 
/*  72 */   private Double ratingLegal = null;
/*     */   private String oldMinimalRating;
/*     */   private String oldMaximalRating;
/*     */   
/*     */   @Before
/*     */   public void setUp()
/*     */     throws ConsistencyCheckException
/*     */   {
/*  80 */     this.demoProduct = ProductManager.getInstance().createProduct("demo1");
/*     */     
/*     */ 
/*     */ 
/*  84 */     Customer demo22 = UserManager.getInstance().createCustomer("demo22");
/*  85 */     Customer demo3 = UserManager.getInstance().createCustomer("demo3");
/*  86 */     Customer demo4 = UserManager.getInstance().createCustomer("demo4");
/*     */     
/*  88 */     this.demoUsers.add(demo22);
/*  89 */     this.demoUsers.add(demo3);
/*  90 */     this.demoUsers.add(demo4);
/*     */     
/*  92 */     this.oldMinimalRating = Config.getParameter("customerreview.minimalrating");
/*  93 */     this.oldMaximalRating = Config.getParameter("customerreview.maximalrating");
/*     */     
/*     */ 
/*  96 */     Config.setParameter("customerreview.minimalrating", String.valueOf(2));
/*  97 */     Config.setParameter("customerreview.maximalrating", String.valueOf(4));
/*  98 */     this.ratingLegal = new Double(3.0D);
/*     */   }
/*     */   
/*     */   @After
/*     */   public void tearDown()
/*     */   {
/* 104 */     Config.setParameter("customerreview.minimalrating", this.oldMinimalRating);
/* 105 */     Config.setParameter("customerreview.maximalrating", this.oldMaximalRating);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private CustomerReview createCR(Double rating)
/*     */   {
/* 117 */     return createCR(rating, (User)this.demoUsers.get(0));
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
/*     */   private CustomerReview createCR(Double rating, User user)
/*     */   {
/* 131 */     return CustomerReviewManager.getInstance().createCustomerReview(rating, "Test headline", "Text text text", user, this.demoProduct);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void testRatingTooSmall()
/*     */   {
/* 139 */     Double ratingTooSmall = new Double(CustomerReviewConstants.getInstance().MINRATING - 1.0D);
/*     */     try
/*     */     {
/* 142 */       createCR(ratingTooSmall);
/* 143 */       Assert.fail("JaloInvalidParameterException expected");
/*     */     }
/*     */     catch (JaloInvalidParameterException localJaloInvalidParameterException) {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void testRatingTooLarge()
/*     */   {
/* 156 */     Double ratingTooLarge = new Double(CustomerReviewConstants.getInstance().MAXRATING + 1.0D);
/*     */     try
/*     */     {
/* 159 */       createCR(ratingTooLarge);
/* 160 */       Assert.fail("JaloInvalidParameterException expected");
/*     */     }
/*     */     catch (JaloInvalidParameterException localJaloInvalidParameterException) {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Test
/*     */   public void testCorrectSetting()
/*     */   {
/* 174 */     CustomerReview cr = createCR(this.ratingLegal);
/* 175 */     Assert.assertEquals(this.ratingLegal, cr.getRating());
/* 176 */     Assert.assertEquals("Test headline", cr.getHeadline());
/* 177 */     Assert.assertEquals("Text text text", cr.getComment());
/* 178 */     cr.setRating(CustomerReviewConstants.getInstance().MAXRATING);
/* 179 */     Assert.assertEquals(new Double(CustomerReviewConstants.getInstance().MAXRATING), cr.getRating());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void testRatingTooLargeInSetter()
/*     */   {
/* 187 */     Double ratingTooLarge = new Double(CustomerReviewConstants.getInstance().MAXRATING + 1.0D);
/* 188 */     CustomerReview cr = createCR(this.ratingLegal);
/*     */     try
/*     */     {
/* 191 */       cr.setRating(ratingTooLarge);
/* 192 */       Assert.fail("JaloInvalidParameterException expected");
/*     */     }
/*     */     catch (JaloInvalidParameterException localJaloInvalidParameterException) {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void testAverageCorrectness()
/*     */   {
/* 205 */     Config.setParameter("customerreview.minimalrating", String.valueOf(1));
/* 206 */     Config.setParameter("customerreview.maximalrating", String.valueOf(10));
/*     */     
/* 208 */     createCR(Double.valueOf(2.0D), (User)this.demoUsers.get(0));
/* 209 */     createCR(Double.valueOf(4.0D), (User)this.demoUsers.get(1));
/* 210 */     createCR(Double.valueOf(7.0D), (User)this.demoUsers.get(2));
/*     */     
/* 212 */     Assert.assertEquals(4.333333333333333D, CustomerReviewManager.getInstance().getAverageRatingAsPrimitive(this.demoProduct), 
/* 213 */       1.0E-7D);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Test
/*     */   public void testOrderOfReviews()
/*     */   {
/* 223 */     Config.setParameter("customerreview.minimalrating", String.valueOf(1));
/* 224 */     Config.setParameter("customerreview.maximalrating", String.valueOf(10));
/* 225 */     createCR(new Double(2.0D), (User)this.demoUsers.get(0));
/* 226 */     createCR(new Double(2.0D), (User)this.demoUsers.get(1));
/* 227 */     createCR(new Double(3.0D), (User)this.demoUsers.get(2));
/*     */     
/*     */     try
/*     */     {
/* 231 */       Thread.sleep(1000L);
/*     */     }
/*     */     catch (InterruptedException e)
/*     */     {
/* 235 */       e.printStackTrace();
/*     */     }
/* 237 */     CustomerReview newReview = CustomerReviewManager.getInstance().createCustomerReview(new Double(3.0D), "Test headline", "Text text text", 
/* 238 */       (User)this.demoUsers.get(1), this.demoProduct);
/* 239 */     SessionContext ctx = CustomerReviewManager.getInstance().getSession().getSessionContext();
/* 240 */     List<CustomerReview> reviewList = CustomerReviewManager.getInstance().getAllReviews(ctx, this.demoProduct);
/* 241 */     CustomerReview firstReview = (CustomerReview)reviewList.get(0);
/*     */     
/* 243 */     if (reviewList.size() < 2)
/*     */     {
/* 245 */       Assert.fail("Test of order is nonsense as only one review in list");
/*     */     }
/* 247 */     Assert.assertEquals(newReview.getPK(), firstReview.getPK());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Test
/*     */   public void testBlockedReviews()
/*     */   {
/* 257 */     UserGroup userGroup = null;
/*     */     try
/*     */     {
/* 260 */       userGroup = UserManager.getInstance().createUserGroup("customergroup");
/*     */ 
/*     */     }
/*     */     catch (ConsistencyCheckException e1)
/*     */     {
/* 265 */       e1.printStackTrace();
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 270 */       CustomerReviewManager.getInstance().createEssentialData(null, null);
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 275 */       e.printStackTrace();
/*     */     }
/*     */     
/*     */ 
/* 279 */     SessionContext ctx = CustomerReviewManager.getInstance().getSession().getSessionContext();
/* 280 */     ((Customer)this.demoUsers.get(0)).addToGroup(userGroup);
/* 281 */     ctx.setUser((User)this.demoUsers.get(0));
/*     */     
/*     */ 
/*     */ 
/* 285 */     createCR(new Double(2.0D), (User)this.demoUsers.get(0));
/* 286 */     CustomerReview cR2 = createCR(new Double(3.0D), (User)this.demoUsers.get(1));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 291 */     List<CustomerReview> reviewList = CustomerReviewManager.getInstance().getAllReviews(ctx, this.demoProduct);
/*     */     
/*     */ 
/* 294 */     Assert.assertEquals(2L, reviewList.size());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 299 */     cR2.setBlocked(true);
/*     */     
/* 301 */     reviewList = CustomerReviewManager.getInstance().getAllReviews(ctx, this.demoProduct);
/*     */     
/*     */ 
/* 304 */     Assert.assertEquals(1L, reviewList.size());
/*     */     
/*     */ 
/* 307 */     Assert.assertEquals(new Double(2.0D), ((CustomerReview)reviewList.get(0)).getRating());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 313 */     cR2.setBlocked(false);
/*     */     
/* 315 */     reviewList = CustomerReviewManager.getInstance().getAllReviews(ctx, this.demoProduct);
/*     */     
/*     */ 
/* 318 */     Assert.assertEquals(2L, reviewList.size());
/*     */   }
/*     */ }