/*     */ package de.hybris.platform.customerreview;
/*     */ 
/*     */ import de.hybris.platform.catalog.model.CatalogModel;
/*     */ import de.hybris.platform.catalog.model.CatalogVersionModel;
/*     */ import de.hybris.platform.core.initialization.SystemSetup.Process;
/*     */ import de.hybris.platform.core.initialization.SystemSetup.Type;
/*     */ import de.hybris.platform.core.initialization.SystemSetupContext;
/*     */ import de.hybris.platform.core.model.product.ProductModel;
/*     */ import de.hybris.platform.core.model.user.UserGroupModel;
/*     */ import de.hybris.platform.core.model.user.UserModel;
/*     */ import de.hybris.platform.customerreview.enums.CustomerReviewApprovalType;
/*     */ import de.hybris.platform.customerreview.model.CustomerReviewModel;
/*     */ import de.hybris.platform.customerreview.setup.CustomerReviewSystemSetup;
/*     */ import de.hybris.platform.search.restriction.SearchRestrictionService;
/*     */ import de.hybris.platform.servicelayer.ServicelayerTest;
/*     */ import de.hybris.platform.servicelayer.i18n.CommonI18NService;
/*     */ import de.hybris.platform.servicelayer.model.ModelService;
/*     */ import de.hybris.platform.servicelayer.user.UserService;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.junit.Assert;
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
/*     */ public class SearchRestrictionTest
/*     */   extends ServicelayerTest
/*     */ {
/*     */   private static final String INVALID_NUMBER_OF_CUSTOMER_REVIEWS = "invalid number of customer reviews";
/*     */   private static final String TEST_PRODUCT = "test_product";
/*     */   private static final String TEST_VERSION = "test_version";
/*     */   private static final String TEST_CATALOG = "test_catalog";
/*     */   private static final String TEST_USER = "test_user";
/*     */   private static final String COMMENT = "comment";
/*     */   private static final String LANG_EN = "en";
/*     */   @Resource
/*     */   private CustomerReviewSystemSetup customerReviewSystemSetup;
/*     */   @Resource
/*     */   private SearchRestrictionService searchRestrictionService;
/*     */   @Resource
/*     */   private CustomerReviewService customerReviewService;
/*     */   @Resource
/*     */   private CommonI18NService commonI18NService;
/*     */   @Resource
/*     */   private ModelService modelService;
/*     */   @Resource
/*     */   private UserService userService;
/*     */   
/*     */   @Test
/*     */   public void searchRestrictionTest()
/*     */   {
/*  76 */     UserGroupModel group = new UserGroupModel();
/*  77 */     group.setUid("customergroup");
/*  78 */     this.modelService.save(group);
/*     */     
/*  80 */     UserModel user = new UserModel();
/*  81 */     user.setUid("test_user");
/*     */     
/*  83 */     user.setGroups(Collections.singleton(group));
/*  84 */     this.modelService.save(user);
/*     */     
/*  86 */     CatalogModel catalog = new CatalogModel();
/*  87 */     catalog.setId("test_catalog");
/*  88 */     this.modelService.save(catalog);
/*     */     
/*  90 */     CatalogVersionModel catalogVersion = new CatalogVersionModel();
/*  91 */     catalogVersion.setCatalog(catalog);
/*  92 */     catalogVersion.setVersion("test_version");
/*  93 */     this.modelService.save(catalogVersion);
/*     */     
/*  95 */     ProductModel product = new ProductModel();
/*  96 */     product.setCode("test_product");
/*  97 */     product.setCatalogVersion(catalogVersion);
/*  98 */     this.modelService.save(product);
/*     */     
/* 100 */     this.userService.setCurrentUser(user);
/*     */     
/* 102 */     this.commonI18NService.setCurrentLanguage(this.commonI18NService.getLanguage("en"));
/* 103 */     Map<String, String[]> params = new HashMap();
/* 104 */     params.put("customerreview.searchrestrictions.create", 
/* 105 */       new String[] { "true" });
/* 106 */     SystemSetupContext ctx = new SystemSetupContext(params, SystemSetup.Type.ESSENTIAL, SystemSetup.Process.ALL, "customerreview");
/* 107 */     this.customerReviewSystemSetup.createSearchRestrictions(ctx);
/*     */     
/* 109 */     this.searchRestrictionService.enableSearchRestrictions();
/*     */     
/* 111 */     Assert.assertEquals("invalid number of customer reviews", Integer.valueOf(0), this.customerReviewService.getNumberOfReviews(product));
/*     */     
/* 113 */     createCustomerReview(null, user, product, CustomerReviewApprovalType.PENDING);
/*     */     
/* 115 */     createCustomerReview("headline", user, product, CustomerReviewApprovalType.APPROVED);
/*     */     
/* 117 */     Assert.assertEquals("invalid number of customer reviews", Integer.valueOf(1), this.customerReviewService.getNumberOfReviews(product));
/*     */     
/* 119 */     this.searchRestrictionService.disableSearchRestrictions();
/*     */     
/* 121 */     Assert.assertEquals("invalid number of customer reviews", Integer.valueOf(2), this.customerReviewService.getNumberOfReviews(product));
/*     */   }
/*     */   
/*     */ 
/*     */   private void createCustomerReview(String headline, UserModel user, ProductModel product, CustomerReviewApprovalType approvalStatus)
/*     */   {
/* 127 */     CustomerReviewModel review = this.customerReviewService.createCustomerReview(Double.valueOf(3.0D), headline, "comment", user, 
/* 128 */       product);
/* 129 */     review.setApprovalStatus(approvalStatus);
/* 130 */     review.setLanguage(this.commonI18NService.getCurrentLanguage());
/* 131 */     this.modelService.save(review);
/*     */   }
/*     */ }