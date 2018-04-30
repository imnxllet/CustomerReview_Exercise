package de.hybris.platform.customerreview.jalo;

/* Import same libraries as CustomerReviewManager class as we are extending its functionality. */
import de.hybris.platform.core.Constants.USER;
import de.hybris.platform.customerreview.constants.GeneratedCustomerReviewConstants.TC;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.SearchResult;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.extension.ExtensionManager;
import de.hybris.platform.jalo.flexiblesearch.FlexibleSearch;
import de.hybris.platform.jalo.product.Product;
import de.hybris.platform.jalo.type.TypeManager;
import de.hybris.platform.jalo.user.User;
import de.hybris.platform.jalo.user.UserGroup;
import de.hybris.platform.jalo.user.UserManager;
import de.hybris.platform.util.JspContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

/* Libraries for reading properties file of curse words*/
import java.io.FileInputStream;
import java.util.Properties;
import java.io.IOException;

/* Libraries that handle rating Exceptions when rating < 0. */
/* Cited from CustomerReview.java.*/
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.JaloInvalidParameterException;
import de.hybris.platform.util.localization.Localization;
import de.hybris.platform.customerreview.constants.CustomerReviewConstants;
 
    /***********************/
	/*                     */
	/*         Note        */
	/*                     */
   	/***********************/
 
/***********************************************************************/
/*How I prepared for this test:										   */
/*1) Research about Java Spring, J2EE.                                 */
/*2) Learn about Spring beans and when should I declare a bean.        */
/*3) Read the Overview doc and wrote down what I need to implement     */
/*4) Brainstorm how I should tackle the problems.                      */
/*5) Find related functions and classes that I should add the extra    */
/*   functionality, and check if anything I can reused or reference.   */
/*6) Study all the classes, files, structure inside src folder.        */
/*              													   */
/*Some note I made to understand the files(classes) structure:		   */
/*-GeneratedTypeInitializer: initialize properties.                    */
/*-CustomerReviewConstant: Get/Set constant.                           */
/* --extends GeneratedCustomerReviewConstant: defined constant.        */
/*-DefaultCustomerDao: Get reviews for product.                        */
/* --implements CustomerReviewDao: interface(function signature).      */
/*-DefaultCustomerReviewService: call CustomerReviewManager.           */
/* --implements CustomerReviewService: create/update/getall....        */
/*-CustomerReview: CreateItem(review)/getRating                        */
/* --extends GeneratedCustomerReview: Get/Set attributes               */
/*-CustomerReviewManager: actual function createReview/update/getall...*/
/* --extends GeneratedCustomerReviewManager: session calls             */
/*                                                                     */
/*7) Decided to extend CustomerReviewManager because it already has a  */
/*   few functions that has similar functionality with requirement (1) */
/*   which is sending SQL query to ask for review count. This class    */
/*   also allows us to examine the review componet(rating, comment,...)*/
/*   before a review a created. Therefore, it's best to extend this    */
/*   class to build the extra filter for rating/comment.               */
/*Some other thoughts:											       */
/*1) Can just create other class for these extra functionalities and   */
/*   use them as helper function inside CustomerReviewManager.         */
/*2) Directly modify CustomerReviewManager and build these functions.  */
/***********************************************************************/




public class ExtendedCustomerReviewManager extends CustomerReviewManager{
	/* Same logger as CustomerReviewManager. */
    private static final Logger LOG = Logger.getLogger(CustomerReviewManager.class.getName());
   
 
 
 
 
 	/* Get Instance of ExtendedCustomerManager. Same idea as CustomerReviewManager. */
    public static ExtendedCustomerReviewManager getInstance(){
        ExtensionManager extensionManager = JaloSession.getCurrentSession().getExtensionManager();
        return (ExtendedCustomerReviewManager)extensionManager.getExtension("customerreview");
    }


    /***********************/
	/*                     */
	/*   Requirement (2)   */
	/*                     */
   	/***********************/


 	/* Create Review. Implemented aditional filter for rating and comment of review.*/
    public CustomerReview createCustomerReview(Double rating, String headline, String comment, User user, Product product){
    	/* Hashmap to store review's component. */
        Map<String, Object> params = new HashMap();
				
		/* An array to store curse words that should be excluded from comment. */
		String[] curse_words = new String[] {};

		/* Initialize prop to store content in properties file. */
		/* properties file is to store curse words. */
		Properties prop = new Properties();

		/* To set-up reading from properties file. */
		FileInputStream properties_file = null;

		/* Try reading the properties file. */
		try{
			/* config.properties file store the curse words. */
			/* Assuming the properties file is stored in the project root. */
			/* we can also read the properties file from classpath as well.(Keep it simple now.) */
		    properties_file = new FileInputStream("/config.properties");

		    /* Load it to prop. */
		    prop.load(properties_file);

		    /* Fill the curse word array with words. */
		    curse_words = prop.getProperty("curse_words").split(",");

		/* Error handling for failed read. Can be handled differently. */
		} catch (IOException ex) {
		    ex.printStackTrace();

		/* Close fileinputstream.*/
		} finally{
		    if(properties_file!=null){
		        try {
		            properties_file.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		}

		/* Check if review's comment contains any curse word. Throw error if it does. */
		for (String word : curse_words) {
		    if(comment.toLowerCase().contains(word.toLowerCase())){
		        /* Throw exception. This exception is cited from CustomerReview.java */
		        /* Used it because invalid comment should be considered as invalid parameter of review. */
		        throw new JaloInvalidParameterException("Comment contains curse word: " + word + " when creating review. ", 0);

		    }
		}

		/* Comment is verified and can be put into hashmap. */
		params.put("comment", comment);

		/* Check if rating is >= 0 */
		/* Cited from CustomerReview.java - setRating function. */
		/* Compared the rating to constant minimum rating. */
		if (rating.doubleValue() < CustomerReviewConstants.getInstance().MINRATING){
		    throw new JaloInvalidParameterException(Localization.getLocalizedString("error.customerreview.invalidrating", 
		    	new Object[] { rating, new Double(CustomerReviewConstants.getInstance().MINRATING), 
		    		new Double(CustomerReviewConstants.getInstance().MAXRATING) }), 0);
   		}

   		/* Put the rating to hashmap if it's valid. */
        params.put("rating", rating);

        /* Put the rest param to hashmap and create the review. */
		params.put("headline", headline);
   		params.put("user", user);
   		params.put("product", product);

   		return createCustomerReview(getSession().getSessionContext(), params);
    }
   
 
    /***********************/
	/*                     */
	/*   Requirement (1)   */
	/*                     */
   	/***********************/


    /* get a product’s total number of customer reviews whose ratings are within a given range (inclusive) */
    /* Extends from function getNumberOfReviews. Added one more condition check using AND after WHERE. */
    /* Checked if a rating is BETWEEN a range (rating_min to rating_max) */
    public Integer getNumberOfReviewsInRange(SessionContext ctx, Product item, double rating_min, double rating_max){
    	/* Create the query to retrieve the review count. */
        String query = "SELECT count(*) FROM {" + GeneratedCustomerReviewConstants.TC.CUSTOMERREVIEW + "} WHERE {" + 
        "product" + "} = ?product" + " AND {rating} BETWEEN " + String.valueOf(rating_min) + " AND " + String.valueOf(rating_max);

        /* Map for merging a specific product to the query. */
        Map<String, Product> values = Collections.singletonMap("product", item);

        /* Perform the query and store the return to result. */
        List<Integer> result = FlexibleSearch.getInstance().search(query, values, 
        	Collections.singletonList(Integer.class), true, true, 0, -1).getResult();

        /* return query result. */
   		return (Integer)result.iterator().next();
    }

 }