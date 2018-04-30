/*     */ package de.hybris.platform.customerreview.setup;
/*     */ 
/*     */ import de.hybris.platform.core.Constants.USER;
/*     */ import de.hybris.platform.core.initialization.SystemSetup;
/*     */ import de.hybris.platform.core.initialization.SystemSetup.Process;
/*     */ import de.hybris.platform.core.initialization.SystemSetup.Type;
/*     */ import de.hybris.platform.core.initialization.SystemSetupContext;
/*     */ import de.hybris.platform.core.model.enumeration.EnumerationValueModel;
/*     */ import de.hybris.platform.core.model.type.ComposedTypeModel;
/*     */ import de.hybris.platform.core.model.type.SearchRestrictionModel;
/*     */ import de.hybris.platform.core.model.user.UserGroupModel;
/*     */ import de.hybris.platform.customerreview.constants.GeneratedCustomerReviewConstants.Enumerations.CustomerReviewApprovalType;
/*     */ import de.hybris.platform.customerreview.constants.GeneratedCustomerReviewConstants.TC;
/*     */ import de.hybris.platform.customerreview.model.CustomerReviewModel;
/*     */ import de.hybris.platform.search.restriction.SearchRestrictionService;
/*     */ import de.hybris.platform.servicelayer.config.ConfigurationService;
/*     */ import de.hybris.platform.servicelayer.model.ModelService;
/*     */ import de.hybris.platform.servicelayer.type.TypeService;
/*     */ import de.hybris.platform.servicelayer.user.UserService;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import org.apache.commons.configuration.Configuration;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.springframework.beans.factory.annotation.Required;
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
/*     */ @SystemSetup(extension="customerreview")
/*     */ public class CustomerReviewSystemSetup
/*     */ {
/*  44 */   private static final Logger LOG = Logger.getLogger(CustomerReviewSystemSetup.class);
/*     */   
/*     */   private static final String SEARCH_RESTRICTION_FRONT_END_REVIEWS = "FrontEnd_Reviews";
/*     */   
/*     */   private static final String SEARCH_RESTRICTION_CREATE_DEFAULT_KEY = "customerreview.searchrestrictions.create";
/*     */   
/*     */   private ModelService modelService;
/*     */   
/*     */   private TypeService typeService;
/*     */   private UserService userService;
/*     */   private SearchRestrictionService searchRestrictionService;
/*     */   private ConfigurationService configurationService;
/*  56 */   private String searchRestrictionCreateKey = "customerreview.searchrestrictions.create";
/*     */   
/*     */   public void setSearchRestrictionCreateKey(String searchRestrictionCreateKey)
/*     */   {
/*  60 */     this.searchRestrictionCreateKey = searchRestrictionCreateKey;
/*     */   }
/*     */   
/*     */   @SystemSetup(type=SystemSetup.Type.ESSENTIAL, process=SystemSetup.Process.ALL)
/*     */   public void createSearchRestrictions(SystemSetupContext context)
/*     */   {
/*  66 */     ComposedTypeModel restrictedType = getTypeService().getComposedTypeForClass(CustomerReviewModel.class);
/*  67 */     UserGroupModel userGroupModel = getUserService().getUserGroupForUID(Constants.USER.CUSTOMER_USERGROUP);
/*  68 */     if (getConfigurationService().getConfiguration().getBoolean(this.searchRestrictionCreateKey))
/*     */     {
/*  70 */       if (LOG.isDebugEnabled())
/*     */       {
/*  72 */         LOG.debug("Creating essential data for customerreview");
/*     */       }
/*     */       
/*  75 */       removeRestrictions(restrictedType, userGroupModel);
/*     */       
/*  77 */       EnumerationValueModel enumerationValueModel = getTypeService().getEnumerationValue(
/*  78 */         GeneratedCustomerReviewConstants.TC.CUSTOMERREVIEWAPPROVALTYPE, 
/*  79 */         GeneratedCustomerReviewConstants.Enumerations.CustomerReviewApprovalType.APPROVED);
/*     */       
/*  81 */       SearchRestrictionModel searchRestriction = (SearchRestrictionModel)getModelService().create(SearchRestrictionModel.class);
/*  82 */       searchRestriction.setCode("FrontEnd_Reviews");
/*  83 */       searchRestriction.setActive(Boolean.TRUE);
/*  84 */       searchRestriction.setQuery("{approvalStatus}=" + enumerationValueModel.getPk());
/*  85 */       searchRestriction.setRestrictedType(restrictedType);
/*  86 */       searchRestriction.setPrincipal(userGroupModel);
/*  87 */       searchRestriction.setGenerate(Boolean.TRUE);
/*  88 */       getModelService().save(searchRestriction);
/*     */     }
/*     */     else
/*     */     {
/*  92 */       if (LOG.isDebugEnabled())
/*     */       {
/*  94 */         LOG.debug("Creating essential data for customerreview skipped, due to '" + 
/*  95 */           this.searchRestrictionCreateKey + "' is not setup");
/*     */       }
/*  97 */       removeRestrictions(restrictedType, userGroupModel);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void removeRestrictions(ComposedTypeModel restrictedType, UserGroupModel userGroupModel)
/*     */   {
/* 106 */     Collection<SearchRestrictionModel> restrictions = getSearchRestrictionService().getSearchRestrictions(userGroupModel, 
/* 107 */       true, Collections.singleton(restrictedType));
/*     */     
/* 109 */     for (SearchRestrictionModel r : restrictions)
/*     */     {
/* 111 */       if (r.getCode().equals("FrontEnd_Reviews"))
/*     */       {
/* 113 */         this.modelService.remove(r);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   protected ModelService getModelService()
/*     */   {
/* 120 */     return this.modelService;
/*     */   }
/*     */   
/*     */   @Required
/*     */   public void setModelService(ModelService modelService)
/*     */   {
/* 126 */     this.modelService = modelService;
/*     */   }
/*     */   
/*     */   protected TypeService getTypeService()
/*     */   {
/* 131 */     return this.typeService;
/*     */   }
/*     */   
/*     */   @Required
/*     */   public void setTypeService(TypeService typeService)
/*     */   {
/* 137 */     this.typeService = typeService;
/*     */   }
/*     */   
/*     */   protected UserService getUserService()
/*     */   {
/* 142 */     return this.userService;
/*     */   }
/*     */   
/*     */   @Required
/*     */   public void setUserService(UserService userService)
/*     */   {
/* 148 */     this.userService = userService;
/*     */   }
/*     */   
/*     */   protected SearchRestrictionService getSearchRestrictionService()
/*     */   {
/* 153 */     return this.searchRestrictionService;
/*     */   }
/*     */   
/*     */   @Required
/*     */   public void setSearchRestrictionService(SearchRestrictionService searchRestrictionService)
/*     */   {
/* 159 */     this.searchRestrictionService = searchRestrictionService;
/*     */   }
/*     */   
/*     */   public ConfigurationService getConfigurationService()
/*     */   {
/* 164 */     return this.configurationService;
/*     */   }
/*     */   
/*     */   @Required
/*     */   public void setConfigurationService(ConfigurationService configurationService)
/*     */   {
/* 170 */     this.configurationService = configurationService;
/*     */   }
/*     */ }