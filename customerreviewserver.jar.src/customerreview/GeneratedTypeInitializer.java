/*     */ package customerreview;
/*     */ 
/*     */ import de.hybris.platform.customerreview.jalo.CustomerReview;
/*     */ import de.hybris.platform.jalo.JaloBusinessException;
/*     */ import de.hybris.platform.persistence.AbstractTypeInitializer;
/*     */ import de.hybris.platform.persistence.ManagerEJB;
/*     */ import de.hybris.platform.persistence.enumeration.EnumerationManagerEJB;
/*     */ import java.util.Arrays;
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
/*     */ public class GeneratedTypeInitializer
/*     */   extends AbstractTypeInitializer
/*     */ {
/*     */   public GeneratedTypeInitializer(ManagerEJB manager, Map params)
/*     */   {
/*  27 */     super(manager, params);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void performRemoveObjects(ManagerEJB manager, Map params)
/*     */     throws JaloBusinessException
/*     */   {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected final void performCreateTypes(ManagerEJB manager, Map params)
/*     */     throws JaloBusinessException
/*     */   {
/*  49 */     createItemType(
/*  50 */       "CustomerReview", 
/*  51 */       "GenericItem", 
/*  52 */       CustomerReview.class, 
/*  53 */       "de.hybris.platform.persistence.customerreview_CustomerReview", 
/*  54 */       false, 
/*  55 */       null, 
/*  56 */       false);
/*     */     
/*     */ 
/*  59 */     createRelationType(
/*  60 */       "ReviewToUserRel", 
/*  61 */       null, 
/*  62 */       true);
/*     */     
/*     */ 
/*  65 */     createRelationType(
/*  66 */       "ReviewToProductRel", 
/*  67 */       null, 
/*  68 */       true);
/*     */     
/*     */ 
/*  71 */     createEnumerationType("CustomerReviewApprovalType", null);
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
/*     */   protected final void performModifyTypes(ManagerEJB manager, Map params)
/*     */     throws JaloBusinessException
/*     */   {
/*  89 */     single_createattr_CustomerReview_headline();
/*     */     
/*  91 */     single_createattr_CustomerReview_comment();
/*     */     
/*  93 */     single_createattr_CustomerReview_rating();
/*     */     
/*  95 */     single_createattr_CustomerReview_blocked();
/*     */     
/*  97 */     single_createattr_CustomerReview_alias();
/*     */     
/*  99 */     single_createattr_CustomerReview_approvalStatus();
/*     */     
/* 101 */     single_createattr_CustomerReview_language();
/*     */     
/* 103 */     single_createattr_Product_numberOfReviews();
/*     */     
/* 105 */     single_createattr_Product_averageRating();
/*     */     
/* 107 */     createRelationAttributes(
/* 108 */       "ReviewToUserRel", 
/* 109 */       false, 
/*     */       
/* 111 */       "user", 
/* 112 */       "User", 
/* 113 */       true, 
/* 114 */       2069, 
/* 115 */       false, 
/* 116 */       false, 
/* 117 */       0, 
/* 118 */       "customerReviews", 
/* 119 */       "CustomerReview", 
/* 120 */       true, 
/* 121 */       2077, 
/* 122 */       true, 
/* 123 */       false, 
/* 124 */       0);
/*     */     
/*     */ 
/* 127 */     createRelationAttributes(
/* 128 */       "ReviewToProductRel", 
/* 129 */       false, 
/*     */       
/* 131 */       "product", 
/* 132 */       "Product", 
/* 133 */       true, 
/* 134 */       2069, 
/* 135 */       false, 
/* 136 */       false, 
/* 137 */       0, 
/* 138 */       "productReviews", 
/* 139 */       "CustomerReview", 
/* 140 */       true, 
/* 141 */       63, 
/* 142 */       true, 
/* 143 */       false, 
/* 144 */       0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void single_createattr_CustomerReview_headline()
/*     */     throws JaloBusinessException
/*     */   {
/* 154 */     Map sqlColumnDefinitions = null;
/*     */     
/* 156 */     createPropertyAttribute(
/* 157 */       "CustomerReview", 
/* 158 */       "headline", 
/* 159 */       null, 
/* 160 */       "java.lang.String", 
/* 161 */       2079, 
/* 162 */       null, 
/* 163 */       sqlColumnDefinitions);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void single_createattr_CustomerReview_comment()
/*     */     throws JaloBusinessException
/*     */   {
/* 171 */     Map sqlColumnDefinitions = new HashMap();
/*     */     
/* 173 */     sqlColumnDefinitions.put(
/* 174 */       "oracle", 
/* 175 */       "CLOB");
/*     */     
/*     */ 
/* 178 */     sqlColumnDefinitions.put(
/* 179 */       "_no_db_", 
/* 180 */       "HYBRIS.LONG_STRING");
/*     */     
/*     */ 
/* 183 */     createPropertyAttribute(
/* 184 */       "CustomerReview", 
/* 185 */       "comment", 
/* 186 */       null, 
/* 187 */       "java.lang.String", 
/* 188 */       2079, 
/* 189 */       null, 
/* 190 */       sqlColumnDefinitions);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void single_createattr_CustomerReview_rating()
/*     */     throws JaloBusinessException
/*     */   {
/* 198 */     Map sqlColumnDefinitions = null;
/*     */     
/* 200 */     createPropertyAttribute(
/* 201 */       "CustomerReview", 
/* 202 */       "rating", 
/* 203 */       null, 
/* 204 */       "java.lang.Double", 
/* 205 */       2071, 
/* 206 */       null, 
/* 207 */       sqlColumnDefinitions);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void single_createattr_CustomerReview_blocked()
/*     */     throws JaloBusinessException
/*     */   {
/* 215 */     Map sqlColumnDefinitions = null;
/*     */     
/* 217 */     createPropertyAttribute(
/* 218 */       "CustomerReview", 
/* 219 */       "blocked", 
/* 220 */       null, 
/* 221 */       "java.lang.Boolean", 
/* 222 */       2071, 
/* 223 */       null, 
/* 224 */       sqlColumnDefinitions);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void single_createattr_CustomerReview_alias()
/*     */     throws JaloBusinessException
/*     */   {
/* 232 */     Map sqlColumnDefinitions = null;
/*     */     
/* 234 */     createPropertyAttribute(
/* 235 */       "CustomerReview", 
/* 236 */       "alias", 
/* 237 */       null, 
/* 238 */       "java.lang.String", 
/* 239 */       31, 
/* 240 */       null, 
/* 241 */       sqlColumnDefinitions);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void single_createattr_CustomerReview_approvalStatus()
/*     */     throws JaloBusinessException
/*     */   {
/* 249 */     Map sqlColumnDefinitions = null;
/*     */     
/* 251 */     createPropertyAttribute(
/* 252 */       "CustomerReview", 
/* 253 */       "approvalStatus", 
/* 254 */       null, 
/* 255 */       "CustomerReviewApprovalType", 
/* 256 */       2071, 
/* 257 */       null, 
/* 258 */       sqlColumnDefinitions);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void single_createattr_CustomerReview_language()
/*     */     throws JaloBusinessException
/*     */   {
/* 266 */     Map sqlColumnDefinitions = null;
/*     */     
/* 268 */     createPropertyAttribute(
/* 269 */       "CustomerReview", 
/* 270 */       "language", 
/* 271 */       null, 
/* 272 */       "Language", 
/* 273 */       31, 
/* 274 */       null, 
/* 275 */       sqlColumnDefinitions);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void single_createattr_Product_numberOfReviews()
/*     */     throws JaloBusinessException
/*     */   {
/* 283 */     createJaloAttribute(
/* 284 */       "Product", 
/* 285 */       "numberOfReviews", 
/* 286 */       "java.lang.Integer", 
/* 287 */       null, 
/* 288 */       29);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void single_createattr_Product_averageRating()
/*     */     throws JaloBusinessException
/*     */   {
/* 296 */     createJaloAttribute(
/* 297 */       "Product", 
/* 298 */       "averageRating", 
/* 299 */       "java.lang.Double", 
/* 300 */       null, 
/* 301 */       29);
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
/*     */   protected final void performCreateObjects(ManagerEJB manager, Map params)
/*     */     throws JaloBusinessException
/*     */   {
/* 317 */     createEnumerationValues(
/* 318 */       "CustomerReviewApprovalType", 
/* 319 */       false, 
/* 320 */       Arrays.asList(new String[] {
/*     */       
/* 322 */       "approved", 
/* 323 */       "pending", 
/* 324 */       "rejected" }));
/*     */     
/*     */ 
/*     */ 
/* 328 */     single_setRelAttributeProperties_ReviewToUserRel_source();
/*     */     
/* 330 */     single_setRelAttributeProperties_ReviewToProductRel_source();
/*     */     
/* 332 */     single_setRelAttributeProperties_ReviewToUserRel_target();
/*     */     
/* 334 */     single_setRelAttributeProperties_ReviewToProductRel_target();
/*     */     
/* 336 */     connectRelation(
/* 337 */       "ReviewToUserRel", 
/* 338 */       false, 
/* 339 */       "user", 
/* 340 */       "User", 
/* 341 */       true, 
/* 342 */       2069, 
/* 343 */       "customerReviews", 
/* 344 */       "CustomerReview", 
/* 345 */       true, 
/* 346 */       2077, 
/* 347 */       true, 
/* 348 */       true);
/*     */     
/*     */ 
/* 351 */     connectRelation(
/* 352 */       "ReviewToProductRel", 
/* 353 */       false, 
/* 354 */       "product", 
/* 355 */       "Product", 
/* 356 */       true, 
/* 357 */       2069, 
/* 358 */       "productReviews", 
/* 359 */       "CustomerReview", 
/* 360 */       true, 
/* 361 */       63, 
/* 362 */       true, 
/* 363 */       true);
/*     */     
/*     */ 
/*     */ 
/* 367 */     Map customPropsMap = new HashMap();
/*     */     
/* 369 */     setItemTypeProperties(
/* 370 */       "CustomerReview", 
/* 371 */       false, 
/* 372 */       true, 
/* 373 */       true, 
/* 374 */       null, 
/* 375 */       customPropsMap);
/*     */     
/*     */ 
/*     */ 
/* 379 */     single_setAttributeProperties_CustomerReview_headline();
/*     */     
/* 381 */     single_setAttributeProperties_CustomerReview_comment();
/*     */     
/* 383 */     single_setAttributeProperties_CustomerReview_rating();
/*     */     
/* 385 */     single_setAttributeProperties_CustomerReview_blocked();
/*     */     
/* 387 */     single_setAttributeProperties_CustomerReview_alias();
/*     */     
/* 389 */     single_setAttributeProperties_CustomerReview_approvalStatus();
/*     */     
/* 391 */     single_setAttributeProperties_CustomerReview_language();
/*     */     
/*     */ 
/* 394 */     Map customPropsMap = new HashMap();
/*     */     
/* 396 */     changeMetaType(
/* 397 */       "Product", 
/* 398 */       null, 
/* 399 */       customPropsMap);
/*     */     
/*     */ 
/*     */ 
/* 403 */     single_setAttributeProperties_Product_numberOfReviews();
/*     */     
/* 405 */     single_setAttributeProperties_Product_averageRating();
/*     */     
/* 407 */     setDefaultProperties(
/* 408 */       "CustomerReviewApprovalType", 
/* 409 */       true, 
/* 410 */       true, 
/* 411 */       null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void single_setAttributeProperties_CustomerReview_headline()
/*     */     throws JaloBusinessException
/*     */   {
/* 423 */     Map customPropsMap = new HashMap();
/*     */     
/* 425 */     setAttributeProperties(
/* 426 */       "CustomerReview", 
/* 427 */       "headline", 
/* 428 */       false, 
/* 429 */       null, 
/* 430 */       null, 
/* 431 */       null, 
/* 432 */       true, 
/* 433 */       true, 
/* 434 */       null, 
/* 435 */       customPropsMap, 
/* 436 */       null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void single_setAttributeProperties_CustomerReview_comment()
/*     */     throws JaloBusinessException
/*     */   {
/* 445 */     Map customPropsMap = new HashMap();
/*     */     
/* 447 */     setAttributeProperties(
/* 448 */       "CustomerReview", 
/* 449 */       "comment", 
/* 450 */       false, 
/* 451 */       null, 
/* 452 */       null, 
/* 453 */       null, 
/* 454 */       true, 
/* 455 */       true, 
/* 456 */       null, 
/* 457 */       customPropsMap, 
/* 458 */       null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void single_setAttributeProperties_CustomerReview_rating()
/*     */     throws JaloBusinessException
/*     */   {
/* 467 */     Map customPropsMap = new HashMap();
/*     */     
/* 469 */     setAttributeProperties(
/* 470 */       "CustomerReview", 
/* 471 */       "rating", 
/* 472 */       false, 
/* 473 */       null, 
/* 474 */       null, 
/* 475 */       null, 
/* 476 */       true, 
/* 477 */       true, 
/* 478 */       null, 
/* 479 */       customPropsMap, 
/* 480 */       null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void single_setAttributeProperties_CustomerReview_blocked()
/*     */     throws JaloBusinessException
/*     */   {
/* 489 */     Map customPropsMap = new HashMap();
/*     */     
/* 491 */     setAttributeProperties(
/* 492 */       "CustomerReview", 
/* 493 */       "blocked", 
/* 494 */       false, 
/* 495 */       Boolean.FALSE, 
/* 496 */       "java.lang.Boolean.FALSE", 
/* 497 */       null, 
/* 498 */       true, 
/* 499 */       true, 
/* 500 */       null, 
/* 501 */       customPropsMap, 
/* 502 */       null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void single_setAttributeProperties_CustomerReview_alias()
/*     */     throws JaloBusinessException
/*     */   {
/* 511 */     Map customPropsMap = new HashMap();
/*     */     
/* 513 */     setAttributeProperties(
/* 514 */       "CustomerReview", 
/* 515 */       "alias", 
/* 516 */       false, 
/* 517 */       null, 
/* 518 */       null, 
/* 519 */       null, 
/* 520 */       true, 
/* 521 */       true, 
/* 522 */       null, 
/* 523 */       customPropsMap, 
/* 524 */       null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void single_setAttributeProperties_CustomerReview_approvalStatus()
/*     */     throws JaloBusinessException
/*     */   {
/* 533 */     Map customPropsMap = new HashMap();
/*     */     
/* 535 */     setAttributeProperties(
/* 536 */       "CustomerReview", 
/* 537 */       "approvalStatus", 
/* 538 */       false, 
/* 539 */       em().getEnumerationValue("CustomerReviewApprovalType", "pending"), 
/* 540 */       "em().getEnumerationValue(\"CustomerReviewApprovalType\",\"pending\")", 
/* 541 */       null, 
/* 542 */       true, 
/* 543 */       true, 
/* 544 */       null, 
/* 545 */       customPropsMap, 
/* 546 */       null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void single_setAttributeProperties_CustomerReview_language()
/*     */     throws JaloBusinessException
/*     */   {
/* 555 */     Map customPropsMap = new HashMap();
/*     */     
/* 557 */     setAttributeProperties(
/* 558 */       "CustomerReview", 
/* 559 */       "language", 
/* 560 */       false, 
/* 561 */       null, 
/* 562 */       null, 
/* 563 */       null, 
/* 564 */       true, 
/* 565 */       true, 
/* 566 */       null, 
/* 567 */       customPropsMap, 
/* 568 */       null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void single_setAttributeProperties_Product_numberOfReviews()
/*     */     throws JaloBusinessException
/*     */   {
/* 577 */     Map customPropsMap = new HashMap();
/*     */     
/* 579 */     setAttributeProperties(
/* 580 */       "Product", 
/* 581 */       "numberOfReviews", 
/* 582 */       false, 
/* 583 */       null, 
/* 584 */       null, 
/* 585 */       null, 
/* 586 */       true, 
/* 587 */       true, 
/* 588 */       null, 
/* 589 */       customPropsMap, 
/* 590 */       null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void single_setAttributeProperties_Product_averageRating()
/*     */     throws JaloBusinessException
/*     */   {
/* 599 */     Map customPropsMap = new HashMap();
/*     */     
/* 601 */     setAttributeProperties(
/* 602 */       "Product", 
/* 603 */       "averageRating", 
/* 604 */       false, 
/* 605 */       null, 
/* 606 */       null, 
/* 607 */       null, 
/* 608 */       true, 
/* 609 */       true, 
/* 610 */       null, 
/* 611 */       customPropsMap, 
/* 612 */       null);
/*     */   }
/*     */   
/*     */ 
/*     */   public void single_setRelAttributeProperties_ReviewToUserRel_source()
/*     */     throws JaloBusinessException
/*     */   {
/* 619 */     Map customPropsMap = new HashMap();
/*     */     
/*     */ 
/* 622 */     setAttributeProperties(
/* 623 */       "CustomerReview", 
/* 624 */       "user", 
/* 625 */       true, 
/* 626 */       null, 
/* 627 */       null, 
/* 628 */       null, 
/* 629 */       true, 
/* 630 */       true, 
/* 631 */       null, 
/* 632 */       customPropsMap, 
/* 633 */       null);
/*     */   }
/*     */   
/*     */ 
/*     */   public void single_setRelAttributeProperties_ReviewToUserRel_target()
/*     */     throws JaloBusinessException
/*     */   {
/* 640 */     Map customPropsMap = new HashMap();
/*     */     
/*     */ 
/* 643 */     setAttributeProperties(
/* 644 */       "User", 
/* 645 */       "customerReviews", 
/* 646 */       false, 
/* 647 */       null, 
/* 648 */       null, 
/* 649 */       null, 
/* 650 */       true, 
/* 651 */       true, 
/* 652 */       null, 
/* 653 */       customPropsMap, 
/* 654 */       null);
/*     */   }
/*     */   
/*     */ 
/*     */   public void single_setRelAttributeProperties_ReviewToProductRel_source()
/*     */     throws JaloBusinessException
/*     */   {
/* 661 */     Map customPropsMap = new HashMap();
/*     */     
/*     */ 
/* 664 */     setAttributeProperties(
/* 665 */       "CustomerReview", 
/* 666 */       "product", 
/* 667 */       true, 
/* 668 */       null, 
/* 669 */       null, 
/* 670 */       null, 
/* 671 */       true, 
/* 672 */       true, 
/* 673 */       null, 
/* 674 */       customPropsMap, 
/* 675 */       null);
/*     */   }
/*     */   
/*     */ 
/*     */   public void single_setRelAttributeProperties_ReviewToProductRel_target()
/*     */     throws JaloBusinessException
/*     */   {
/* 682 */     Map customPropsMap = new HashMap();
/*     */     
/*     */ 
/* 685 */     setAttributeProperties(
/* 686 */       "Product", 
/* 687 */       "productReviews", 
/* 688 */       false, 
/* 689 */       null, 
/* 690 */       null, 
/* 691 */       null, 
/* 692 */       true, 
/* 693 */       true, 
/* 694 */       null, 
/* 695 */       customPropsMap, 
/* 696 */       null);
/*     */   }
/*     */ }