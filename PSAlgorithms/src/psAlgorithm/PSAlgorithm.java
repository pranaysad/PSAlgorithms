/**
 * 
 */
package psAlgorithm;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import nl.flotsam.xeger.Xeger;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.datavec.api.io.labels.ParentPathLabelGenerator;
import org.datavec.api.split.FileSplit;
import org.datavec.image.loader.NativeImageLoader;
import org.datavec.image.recordreader.BaseImageRecordReader;
import org.datavec.image.recordreader.ImageRecordReader;
import org.deeplearning4j.datasets.datavec.RecordReaderDataSetIterator;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.api.Updater;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.inputs.InputType;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;

import org.joda.time.DateTime;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.dataset.api.preprocessor.DataNormalization;
import org.nd4j.linalg.dataset.api.preprocessor.ImagePreProcessingScaler;
import org.nd4j.linalg.lossfunctions.LossFunctions;
import org.deeplearning4j.eval.Evaluation;

import org.deeplearning4j.api.storage.StatsStorage;
//import org.deeplearning4j.examples.userInterface.util.UIExampleUtils;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
//import org.deeplearning4j.ui.api.UIServer;

//import org.deeplearning4j.ui.stats.StatsListener;

//import org.deeplearning4j.ui.storage.InMemoryStatsStorage;

//import org.deeplearning4j.ui.storage.InMemoryStatsStorage;

import org.deeplearning4j.api.storage.*;

import org.deeplearning4j.ui.UiServer;
import org.deeplearning4j.ui.UiUtils;

import org.deeplearning4j.ui.storage.*;
import org.deeplearning4j.util.ModelSerializer;
import org.deeplearning4j.api.storage.StatsStorage;


import org.deeplearning4j.ui.servlet.*;




import java.sql.*;


/**
 * @author pranaysadarangani
 *
 */
public class PSAlgorithm {
	
	static int globalcounter;

	static boolean isPalindrome(int num)
	{
		String strNum = Integer.toString(num);
		int strLen = strNum.length();
		boolean bPalindrome = true;
		boolean isEven = false;
		int middle=0;
		
		System.out.println("isPalindrome");
		System.out.println("Num = " + num);
		//012345
		//123321
		//strLen=6
		//middle=6/2=3
		//0 1 2
		
		if ( (strLen % 2) == 0)	{
			
			isEven = true;
			middle = (strLen/2);
			
			for(int i=0;i<middle;i++)
			{
				//	0 compared with 5
				//	1 compared with 4
				//	2 compared with 3
				System.out.println("Even");
				System.out.println("middle = " + middle);
				System.out.println(i);
				System.out.println(strLen-i-1);
				
				System.out.println(strNum.charAt(i));
				System.out.println(strNum.charAt(strLen-i-1));
				if (strNum.charAt(i)!=strNum.charAt(strLen-i-1)) bPalindrome=false;
				
			}
			
		}
		else {
			//0123456
			//1234321
			//strLen=7
			//middle=(7-1)/2=3
			System.out.println("Odd");
			
			isEven=false;
			middle = ((strLen-1)/2);
			
			for(int i=0;i<middle;i++)
			{
				//	0 compared with 6
				//	1 compared with 5
				//	2 compared with 4
				System.out.println(strNum.charAt(i));
				System.out.println(strNum.charAt(strLen-i-1));
				if (strNum.charAt(i)!=strNum.charAt(strLen-i-1)) bPalindrome=false;	
			}
			
		}
		

		//	121	
		//	1221
		System.out.println("bPalindrome = " + bPalindrome);
		
		return bPalindrome;
		
	}
	
    static String nearestPalindrome(String n) {
    					
        String strNear = null;
    	
        //	Convert String to number
        // 	Go one up and 2 down and so on..
        //	+1 -2 +3 -4 +5 -6 +7
        //	
        
        //int iNumber = Integer.parseInt(n);
        
        int iNumber = Integer.valueOf(n);
        
        
        
        //int iNumber = NumberFormat.getInstance().parse(string);
        
        boolean bPalindrome=false;
        
        int step = 1;

        int iLoopCount=0;
        
        while(!bPalindrome)
        {
        	
        	iLoopCount++;
        	
        	System.out.println(step);
        	System.out.println(iNumber);
        	
        	iNumber = iNumber + step;
        	
        	bPalindrome= isPalindrome(iNumber);
        	
        	if (step>0)
        	{	
        		step = -(step + 1);
        	}	
        	else
        	{	
        		step = Math.abs(step) + 1;
        		
        	}	
        	
        	System.out.println("-----");
        	
        	//System.out.println("step = " + step);
        	//System.out.println("Number = " + iNumber);
        
        }
        
        System.out.println(iNumber);
        
        //strNear = Integer.toString(iNumber);
        
        strNear = String.valueOf(iNumber);
       
        
        System.out.println("Loop Count = " + iLoopCount);
        
    	return strNear;
        
    }
   
    static void merge(int[] left, int[] right, int[] arr)
    {	
    	globalcounter++;
    	
    	int leftlen = left.length;
    	int rightlen = right.length;
    	int arrlen = arr.length;
    	
    	int leftcount=0;
    	int rightcount=0;
    	int arrcount=0;
    	
    	while(leftcount<leftlen && rightcount<rightlen)
    	{
    		if (left[leftcount]<right[rightcount])
    		{
    			arr[arrcount]=left[leftcount];
    			arrcount++;
    			leftcount++;
    		}
    		else {
    			arr[arrcount]=right[rightcount];
    			arrcount++;
    			rightcount++;
    		}
    	}
    	
    	if (leftcount>=leftlen) {
    		//Left Array exhausted copy the right array over
    		for (int i=rightcount;i<rightlen;i++)
    		{	
    			arr[arrcount]=right[i];
    			arrcount++;
    		}
    		
    	}
    	else {
    		//Right Array exhausted copy the left array over
    		for (int i=leftcount;i<leftlen;i++)
    		{	
    			arr[arrcount]=left[i];
    			arrcount++;
    		}
    		
    	}
    	
    	//System.out.println("arr  = " + Arrays.toString(arr));
    	
    }	
    
    static int[] mergesort(int[] arr)
    {
    	globalcounter++;
    	
    	
    	//System.out.println("arr  = " + Arrays.toString(arr));
    	
    	int length = arr.length;
    	
    	if (length < 2) return null;
    	
    	int mid = length/2;
    	
    	int[] left = new int[mid];
    	int[] right = new int[length-mid];
    	
    	for(int i=0;i<mid;i++) 
    	{
    		//System.out.println("left i = " + i);
    		left[i]=arr[i];
    	}
    	
    	for(int i=mid;i<length;i++) 
    		{
    			//System.out.println("right i = " + i);
    			right[i-mid]=arr[i];
    		}
    	
    	//System.out.println("---");
    	
    	//System.out.println("left  = " + Arrays.toString(left));
    	//System.out.println("right = " + Arrays.toString(right));
    	
    	mergesort(left);//Split the array till you have an array with a single value (single value is sorted)
    	
    	//System.out.println(Arrays.toString(left));
    	
    	mergesort(right);//Split the array till you have an array with a single value (single value is sorted)
    	//System.out.println(Arrays.toString(right));
    	
    	//Now you need to merge the arrays back in the correct order
    	merge(left, right, arr);
    	
    	
    	//System.out.println("arr  = " + Arrays.toString(arr));
    	
    	return arr;
    }
    
    static int[] quicksort(int[] arr) 
    {	
    	
    	if (arr.length <2) return null;
    	
    	int[] sortedarr = new int[arr.length];
    	
    	int pivot = arr.length-1;
    	
    	
    	System.out.println("pivot  = " + pivot);
    	System.out.println("value at pivot = " + arr[pivot]);
    	System.out.println("start arr  = " + Arrays.toString(arr));
    	
    	
    	//All numbers lesser than pivot are towards the left
    	//All numbers greater than pivot are towards the right
    	for (int i=0;i<arr.length;i++)
    	{
    		if ((arr[i]>arr[pivot]) & (i<pivot))
    		{
    			//	If arr[i]>arr[pivot] but i is less than pivot
    			//	If the value is greater than the index should also be greater
    			//	
    			int temp=arr[pivot];
    			arr[pivot]=arr[i];
    			arr[i]=temp;
    			pivot=i;
    		}
    		
    		if ((arr[i]<arr[pivot]) & (i>pivot))
    		{
    			//If arr[i]<arr[pivot] then i should also be lesser than pivot
    			//If the value is lesser than the index should also be lesser
    			int temp=arr[pivot];
    			arr[pivot]=arr[i];
    			arr[i]=temp;
    			pivot=i;
    		}
    	
    		
    	}
    	
    	System.out.println("pivot  = " + pivot);
    	System.out.println("value at pivot = " + arr[pivot]);
    	System.out.println("sorted arr  = " + Arrays.toString(arr));
    	System.out.println("---");
    	
    	//LinkedList --> Number
    	//Add Number
    	//Number --> Linked-List
    	
    	//	Tree and Graph Algorithms
    	//	Dynamic Programming
    	//	Backtracking
    	//	Greedy Algorithms
    	//	Load all the pictures from someones facebook into a model
    	
    	//	FolderName=Someone's name and then the pictures in that folder
    	//	Build a model based on the pictures
    	
    	
    	
    	
    	/*
    	
    	if (pivot==0) return null;
    	
    	if (pivot>0) {
    		
    	System.out.println("Left");
    		
    	int[] leftarr = new int[pivot];
    	
    	for (int i=0;i<pivot;i++)
    	{
    		leftarr[i]=arr[i];
    	}
    	
    	if (leftarr!=null) quicksort(leftarr);
    	
    	}
    	
    	if (pivot<arr.length) {
    		
    	System.out.println("right");
    	
    	System.out.println("arr  = " + Arrays.toString(arr));
    	
    	int[] rightarr = new int[arr.length-pivot];
    	
    	for(int i=pivot+1;i<arr.length;i++)
    	{
    		rightarr[i-pivot]=arr[i];
    	}
    	
    	if (rightarr!=null) quicksort(rightarr);
    	
    	}
    	
    	System.out.println("arr  = " + Arrays.toString(arr));
    	
    	System.out.println("pivot  = " + pivot);
    	System.out.println("arr  = " + Arrays.toString(arr));
    	
    	*/
    	
    	return sortedarr;
    }	
    
    
    
    
    static void machinelearning()
    {
    	
    	//Download images and from different sites on Amazon and check if the image is recognizable
				
    	//Initialize the user interface backend
    	/*
	    try {
			UiServer uiServer = UiServer.getInstance();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    */
	    
	    
	    //Configure where the network information (gradients, score vs. time etc) is to be stored. Here: store in memory.
	    
    	//StatsStorage statsStorage = new InMemoryStatsStorage();         //Alternative: new FileStatsStorage(File), for saving and loading later
	    
	    //StatsStorage statsStorage = new InMemoryStatsStorage
	    		//StatsStorae();
	    
	    //Attach the StatsStorage instance to the UI: this allows the contents of the StatsStorage to be visualized
	    //uiServer.attach(statsStorage);

	    //Then add the StatsListener to collect this information from the network, as it trains
	    //net.setListeners(new StatsListener(statsStorage));

				
    	// DeepLearning4j
    			
    			int height = 28; 		// The number of rows of a matrix. - Image is 28x28 pixels
    			int width = 28; 		// The number of columns of a matrix. - Image is 28x28 pixels
    			
    			int channels = 1;		// 	Grayscale implies single channel
    			int rngseed = 123;		// 	This random-number generator applies a seed to ensure that 
    			  						//	the same initial weights are used when training. 
    			  						//	 We’ll explain why this matters later.
    			
    			Random randNumGen = new Random(rngseed);
    			
    			int numEpochs = 1; 	// An epoch is a complete pass through a given dataset.
    			
    			File trainData = new File(ClassLoader.getSystemResource("training").getPath());
    			System.out.println(trainData.getPath());
    			
    			File testData = new File(ClassLoader.getSystemResource("testing").getPath());
    			System.out.println(testData.getPath());
    			
    			//FileSplit train = new FileSplit(trainData.getAbsoluteFile(), NativeImageLoader.ALLOWED_FORMATS,randNumGen);
    			
    			FileSplit train = new FileSplit(trainData,NativeImageLoader.ALLOWED_FORMATS,randNumGen);
    			FileSplit test = new FileSplit(testData,NativeImageLoader.ALLOWED_FORMATS,randNumGen);
    			
    			ParentPathLabelGenerator labelMaker = new ParentPathLabelGenerator();
    			
    			//ImageRecordReader recordReader = new ImageRecordReader(height,width,channels,labelMaker);
    			ImageRecordReader recordReader = new ImageRecordReader(height,width,channels,labelMaker);
    			
    			try {
    				recordReader.initialize(train);
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			
    			
    			    		 
    			int batchSize = 2;	// How many examples to fetch with each step.
    			int outputNum = 11; 	// Number of possible outcomes (e.g. labels 0 through 7).
    			
    			//	Exception in thread "ADSI prefetch thread" java.lang.RuntimeException: java.lang.UnsupportedOperationException: 
    			//	Cannot do conversion to one hot using batched reader: 1 output classes, 
    			//	but array.size(1) is 7 (must be equal to 1 or numClasses = 1)
    			
    			DataSetIterator dataIter = new RecordReaderDataSetIterator(recordReader,batchSize,1,outputNum);
    			
    	        // Scale pixel values to 0-1
    			
    	        DataNormalization scaler = new ImagePreProcessingScaler(0,1);
    	        scaler.fit(dataIter);
    	        dataIter.setPreProcessor(scaler);
    			
    			MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
    		            .seed(rngseed)
    		            .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
    		            .iterations(1)
    		            .learningRate(0.006)
    		            //.updater(org.deeplearning4j.nn.conf.Updater.NESTEROVS).momentum(0.9)
    		            .updater(org.deeplearning4j.nn.conf.Updater.NESTEROVS)
    		            .regularization(true).l2(1e-4)
    		            .list()
    		            .layer(0, new DenseLayer.Builder()
    		                    .nIn(height * width)
    		                    .nOut(100)
    		                    .activation(Activation.RELU)
    		                    .weightInit(WeightInit.XAVIER)
    		                    .build())
    		            .layer(1, new OutputLayer.Builder(LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD)
    		                    .nIn(100)
    		                    .nOut(outputNum)
    		                    .activation(Activation.SOFTMAX)
    		                    .weightInit(WeightInit.XAVIER)
    		                    .build())
    		            .pretrain(false).backprop(true)
    		            .setInputType(InputType.convolutional(height,width,channels))
    		            .build();
    					
    					
    			
    		    MultiLayerNetwork model = new MultiLayerNetwork(conf);
    		    	    
    		    for(int i = 0; i<numEpochs; i++){
    		    	System.out.println("Training Attempt " + i);
    		        model.fit(dataIter);
    		    }
    		    
    		    System.out.println("**************************");
    	        System.out.println("***** EVALUATE MODEL *****");
    	        System.out.println("**************************");
    	        //Note: Training has 60K files and Testing has 10K files
    	        
    	        recordReader.reset();
    		    
    	        try {
    				recordReader.initialize(test);
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    	        
    		    DataSetIterator testIter = new RecordReaderDataSetIterator(recordReader, batchSize, 1, outputNum);
    		    // org.deeplearning4j.datasets.datavec.RecordReaderDataSetIterator.RecordReaderDataSetIterator(
    		    //	RecordReader recordReader, int batchSize, int labelIndex, int numPossibleLabels)
    		    
    		    scaler.fit(testIter);
    	        testIter.setPreProcessor(scaler);
    		    
    		    Evaluation eval = new Evaluation(outputNum);
    		    
    			while(testIter.hasNext()){
    		        DataSet next = testIter.next();
    		        INDArray output = model.output(next.getFeatureMatrix());
    		        
    		        //System.out.println(next.getLabels().toString());
    		        
    		        eval.eval(next.getLabels(),output);
    		    }
    		    
    		    System.out.println(eval.stats());
    			
    		    System.out.println(eval.confusionToString());
    		    
    		    
    	        MultiLayerNetwork net = new MultiLayerNetwork(conf);
    	        net.init();
    	        
    	      //Save the model
    	        File locationToSave = new File("MyMultiLayerNetwork.zip");      //Where to save the network. Note: the file is in .zip format - can be opened externally
    	        boolean saveUpdater = true;                                             //Updater: i.e., the state for Momentum, RMSProp, Adagrad etc. Save this if you want to train your network more in the future
    	        try {
					ModelSerializer.writeModel(net, locationToSave, saveUpdater);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	        
    	        MultiLayerNetwork restored;
    	        
    	      //Load the model
    	      try {
    	    	  restored = ModelSerializer.restoreMultiLayerNetwork(locationToSave);
    	      } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
    	      }
    	     
    	      

    	      //System.out.println("Saved and loaded parameters are equal:      " + net.params().equals(restored.params()));
    	      //System.out.println("Saved and loaded configurations are equal:  " + net.getLayerWiseConfigurations().equals(restored.getLayerWiseConfigurations()));
    	        
    	        
    	        
    	      
    	
    	
    	
    }
    
    
    
    
    
    
    
    
    
    // JDBC driver name and database URL
    //static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/PRODUCTS?serverTimezone=UTC&useSSL=false";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "S@ndwich10293";
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		//String inNumber = "18435481";
		
		machinelearning();
		
		
        //	*********
	    try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		     
	    
	    
		
		
		long starttime = 0;
		
		long endtime = 0;
		
		
		//	Connect to mySQL
		Connection conn = null;
		Statement statement = null;
		  
		try {
			//STEP 2: Register JDBC driver
			//Class.forName("com.mysql.jdbc.Driver");	
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return;
		}
		
		//STEP 3: Open a connection
		System.out.println("Connecting to database...");
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		System.out.println("Connecting to database...SUCCESS");
		
		
		//STEP 4: Execute a query
		System.out.println("Creating database...");
		try {
			statement = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return;
		}
	    
		System.out.println("Creating database - SUCCESSFUL");
		
		String sql = "CREATE DATABASE IF NOT EXISTS PRODUCTS";
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("Database created successfully...");
		System.out.println("CREATE DATABASE PRODUCTS - SUCCESS");
		
		//Create a Table
        String myTableName = "CREATE TABLE Amazon (" 
                + "idNumber INT(64) NOT NULL,"  
                + "Url VARCHAR(36) NOT NULL," 
                + "Title VARCHAR(256) NOT NULL,"  
                + "Price INT(64),"
                + "Image LONGBLOB NOT NULL"
                + "UNIQUE(Url)"
                + ")"; 
        
        
        // note that i'm leaving "date_created" out of this insert statement
        try {
			statement.executeUpdate(
				"INSERT INTO Amazon (idNumber, Url, Title, Price, Image)"
			    + "VALUES ('B01GEW27DA','https://www.amazon.com/dp/B01GEW27DA', 'Fire 7 Tablet with Alexa', '10000')"
			    );
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
            
        
       
        try {
            statement = conn.createStatement();
            //The next line has the issue
            statement.executeUpdate(myTableName);
            System.out.println("Table Created");
        }
        catch (SQLException e ) {
            System.out.println("An error has occurred on Table Creation");
        }

		
        
        
        
        
        //	*********
	    try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		      
		
	    
	    
		
		//B07B725M81
		//B00006IEED
		//B075F487KG
		
        //String regex = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[\\p{Punct}]).{8,12})";
		
		//B00006IEED
		//String regex = "([B][0][7][0-9][0-9][0-9][A-Z][A-Z][A-Z][A-Z])";
				
		//https://www.amazon.com/dp/B01NBTFNVA
		
		String strURLTest = "http://www.amazon.com/dp/B00N2ZDXW2";
		
		/*
		Document docTest=null;
		try {
			docTest = Jsoup.connect(strURLTest).timeout(1).get();
			String strDocTest = docTest.toString();
			System.out.println(strDocTest);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//continue;
		}   
		
		System.out.println("----------");
		
		System.out.println(strURLTest);
			
	    try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
		*/
		
		String regex = "([A-Z][0-9][0-9][0-9][0-9][0-9][A-Z][A-Z][A-Z][A-Z])";
		//				   10	9	 8	  7	   6	5 	 4	  3		2	1
		
		int arrlen = 26*26*26;
		String strALL[] = new String[arrlen];
		
		int count=0;
		
		for(int p3=0;p3<42;p3++) {
			
			for(int p2=0;p2<42;p2++) {
				
				for(int p1=0;p1<42;p1++) {
										
					strALL[count] = "B0157G3" + 
									String.valueOf((char)(p3+48)) +
									String.valueOf((char)(p2+48)) + 
									String.valueOf((char)(p1+48));
					
					
					//String strURL = "https://www.amazon.com/dp/" + strALL[count];
					//String strURL = "http://www.amazon.com/dp/" + strALL[count];
					
					
					String strURL = "http://www.amazon.com/dp/B0157G303U";
						
					Response resp = null;
					
					Document doc1=null;
					try {
						
						System.out.println(strURL);
						//starttime = System.currentTimeMillis();
						//doc1 = Jsoup.connect(strURL).timeout(0).get();
						//endtime = System.currentTimeMillis();
						//System.out.println(endtime-starttime);
						
						//Jsoup should connect to header only to make the call fail faster
						
						starttime = System.currentTimeMillis();
						resp = Jsoup.connect(strURL).method(Method.HEAD).execute();
						endtime = System.currentTimeMillis();
						System.out.println(endtime-starttime);
						
						//	Since the connection was successful 
						//	(if we got here that means no exception was thrown and the connection was successful)
						//	Connect to mySQL and save the URL in a table which does not allow duplicates
						
						
						//System.out.println(resp.statusCode());
						
								
					} catch (IOException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();						
						endtime = System.currentTimeMillis();
						System.out.println("IO : " + (endtime-starttime));
				
						continue;
					}   
					
					System.out.println(strURL);
					//System.out.println(resp.statusCode());
					
					count++;
				}
			}
		
		}
		
		System.out.println(count);
		
	    try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		//String regex = "([A-Z][0-9][0-9][0-9][0-9][0-9][A-Z][A-Z][A-Z][A-Z])";
		
        Xeger generator = new Xeger(regex);        
        
        String strGEN = generator.generate();
        
        //System.out.println(strGEN);
        
		//https://www.amazon.com/dp/B00006IEED
		//https://www.amazon.com/dp/B00006IEED
		
		//Data Validation
        
        //strGEN = "B0120XRWLE";
        //strGEN = "B01DK3SOY2";
        
        /*
        InputStream in=null;
		try {
			in = new URL("https://images.craigslist.org/00f0f_gKjiJeSSY8Z_600x450.jpg").openStream();
		} catch (MalformedURLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		
        try {
			Files.copy(in, Paths.get("src/main/resources/test/01515_fxXKOnC1DBE_50x50c.jpg"));
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
        */
        
        
		//String strURL = "https://www.amazon.com/dp/"+ strGEN;
		
		//String strURL = "https://seattle.craigslist.org/see/mat/6663728831.html";
		
		
		//strURL = "https://www.amazon.com/dp/B0120XRWLE";
		
		String strURL = null;
		//strURL = "https://seattle.craigslist.org/skc/emd/6682663802.html";
		
		//https://www.amazon.com/dp/B075F487KG
		//strURL = "https://www.amazon.com/dp/B07B725M81";
		//strURL = "https://www.amazon.com/dp/B075F487KG";
		//https://www.amazon.com/d/B07227SJ1P
		//strURL = "https://www.amazon.com/d/B07227SJ1P";
		//strURL = "https://www.amazon.com/dp/0545935172";
		//strGEN = "Chance Pop Session session three - $15";
		
		//strURL = "https://www.amazon.com/dp/B07BGJZCBN";
		
		//strURL = "https://www.amazon.com/dp/B0040ZON5Y";
		
		strURL = "https://www.amazon.com/dp/"+ strGEN;
		
		//strGEN = "B0040ZON5Y";
		
		
		
		System.out.println(strURL);
		
		File mkdirFile = new File("src/main/resources/" + strGEN);
		boolean bmkdir = true;
		
		if (!mkdirFile.exists())
		{
			bmkdir = new File("src/main/resources/" + strGEN).mkdir();
		}
		
		System.out.println(mkdirFile.toString());
						
		URL website = null;
		try {
			website = new URL(strURL);
		} catch (MalformedURLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();		
		}
		
		Document doc=null;
		try {
			doc = Jsoup.connect(strURL).timeout(0).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		
		Set<String> urlSet = new HashSet<String>();
		
		String strDocument = doc.toString();
		
		//System.out.println(strDocument);
		
		String strREGEX = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*jpg";
		
		Pattern pattern = Pattern.compile(strREGEX,Pattern.CASE_INSENSITIVE); // Regex for the value of the key
		Matcher matcher = pattern.matcher(strDocument); // you have to use html here and NOT text! Text will drop the 'key' part
		
		while( matcher.find() )
		{
			//System.out.println(m.group(0)); // value
			String urlStr = matcher.group(0).toString();
			
			//System.out.println(urlStr);
			
			//urlSet.add(matcher.group(0).toString());
	    
		}
		
		Elements scriptElements = doc.getElementsByTag("script");

		for (Element element :scriptElements ){                
		        for (DataNode node : element.dataNodes()) {
		            
		        	//System.out.println(node.getWholeData());
		            
		        	String nodeStr = node.getWholeData();
		        	
		        	String REGEX = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*jpg";
					
					Pattern p = Pattern.compile(REGEX,Pattern.CASE_INSENSITIVE); // Regex for the value of the key
					Matcher m = p.matcher(nodeStr); // you have to use html here and NOT text! Text will drop the 'key' part
					
					while( m.find() )
					{
						System.out.println(m.group(0)); // value
						urlSet.add(m.group(0).toString());
					}
		            
		        }
		                        
		}
		 
		System.out.println("-------------------");    
		
		/*
	    try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		for (int i=0;i<0;i++)
		{
		
			Element script = doc.select("script").get(i);
			
			//System.out.println(script.toString());
		
			//https://www.amazon.com/dp/B0120XRWLE
		
			//String REGEX = "https://images-na.ssl-images-amazon.com/image*jpg$";
			
			//String REGEX = "jpg";
			//String REGEX = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
			
			String REGEX = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*jpg";
			
			Pattern p = Pattern.compile(REGEX,Pattern.CASE_INSENSITIVE); // Regex for the value of the key
			Matcher m = p.matcher(script.html()); // you have to use html here and NOT text! Text will drop the 'key' part
			
			while( m.find() )
			{
				//System.out.println(m.group(0)); // value
				String urlStr = m.group(0).toString();
						
				if (!urlStr.contains("airstream"))	urlSet.add(m.group(0).toString());
				
			}
		}
		
		//urlSet.forEach(System.out::println);
        
		Iterator<String> iter = urlSet.iterator();
		
		while (iter.hasNext()) {
		    
			String strWebpageURL = iter.next();
			
			System.out.println(strWebpageURL);
			
		    URL websiteURL = null;
			try {
				websiteURL = new URL(strWebpageURL);
			} catch (MalformedURLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
				continue;
			}
			
			//Extract ImageFile name from the URL
			//Find the index of the last /
			int slashIndex = strWebpageURL.lastIndexOf("/");
			
			String strImageName = strWebpageURL.substring(slashIndex+1);
			//System.out.println(strImageName);
			
			//Directory was created successfully or already exists
			File imageFile = null;
			//if (bmkdir)
			{
				String strPath = "src/main/resources/" + 
								 strGEN + 
								 "/" + 
								 strImageName;
				
				imageFile = new File(strPath);
				
				
		        InputStream varInputStream=null;
				try {
					varInputStream = new URL(strWebpageURL).openStream();
				} catch (MalformedURLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				
		        try {
					Files.copy(varInputStream, Paths.get(strPath));
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
		        
				/*
				try {
			        
					BufferedImage image = ImageIO.read(website);
					
			        ImageIO.write(image, "jpg", new File(strPath));
			        
					
					//FileUtils.copyURLToFile(website, imageFile);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					continue;
				}
				*/
			}
			
		    //try {
			//	System.in.read();
			//} catch (IOException e) {
				// TODO Auto-generated catch block
			//	e.printStackTrace();
			//}
		    
			
		}
		
		
		
		
		//Download images and from different sites on Amazon and check if the image is recognizable
		
		
		// DeepLearning4j
		
		int height = 28; 		// The number of rows of a matrix. - Image is 28x28 pixels
		int width = 28; 		// The number of columns of a matrix. - Image is 28x28 pixels
		
		int channels = 1;		// 	Grayscale implies single channel
		int rngseed = 123;		// 	This random-number generator applies a seed to ensure that 
		  						//	the same initial weights are used when training. 
		  						//	 We’ll explain why this matters later.
		
		Random randNumGen = new Random(rngseed);
		
		int numEpochs = 1; 	// An epoch is a complete pass through a given dataset.
		
		File trainData = new File(ClassLoader.getSystemResource("training").getPath());
		System.out.println(trainData.getPath());
		
		File testData = new File(ClassLoader.getSystemResource("testing").getPath());
		System.out.println(testData.getPath());
		
		//FileSplit train = new FileSplit(trainData.getAbsoluteFile(), NativeImageLoader.ALLOWED_FORMATS,randNumGen);
		
		FileSplit train = new FileSplit(trainData,NativeImageLoader.ALLOWED_FORMATS,randNumGen);
		FileSplit test = new FileSplit(testData,NativeImageLoader.ALLOWED_FORMATS,randNumGen);
		
		ParentPathLabelGenerator labelMaker = new ParentPathLabelGenerator();
		
		//ImageRecordReader recordReader = new ImageRecordReader(height,width,channels,labelMaker);
		ImageRecordReader recordReader = new ImageRecordReader(height,width,channels,labelMaker);
		
		try {
			recordReader.initialize(train);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int batchSize = 1;	// How many examples to fetch with each step.
		int outputNum = 11; 	// Number of possible outcomes (e.g. labels 0 through 9).
		
		DataSetIterator dataIter = new RecordReaderDataSetIterator(recordReader,batchSize,1,outputNum);
		
        // Scale pixel values to 0-1
		
        DataNormalization scaler = new ImagePreProcessingScaler(0,1);
        scaler.fit(dataIter);
        dataIter.setPreProcessor(scaler);
		
		MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
	            .seed(rngseed)
	            .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
	            .iterations(1)
	            .learningRate(0.006)
	            //.updater(org.deeplearning4j.nn.conf.Updater.NESTEROVS).momentum(0.9)
	            .updater(org.deeplearning4j.nn.conf.Updater.NESTEROVS)
	            .regularization(true).l2(1e-4)
	            .list()
	            .layer(0, new DenseLayer.Builder()
	                    .nIn(height * width)
	                    .nOut(100)
	                    .activation(Activation.RELU)
	                    .weightInit(WeightInit.XAVIER)
	                    .build())
	            .layer(1, new OutputLayer.Builder(LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD)
	                    .nIn(100)
	                    .nOut(outputNum)
	                    .activation(Activation.SOFTMAX)
	                    .weightInit(WeightInit.XAVIER)
	                    .build())
	            .pretrain(false).backprop(true)
	            .setInputType(InputType.convolutional(height,width,channels))
	            .build();
				
				
		
	    MultiLayerNetwork model = new MultiLayerNetwork(conf);
	    
	    for(int i = 0; i<numEpochs; i++){
	    	System.out.println("Training Attempt " + i);
	        model.fit(dataIter);
	    }
	    
	    System.out.println("**************************");
        System.out.println("***** EVALUATE MODEL *****");
        System.out.println("**************************");
        //Note: Training has 60K files and Testing has 10K files
        
        recordReader.reset();
	    
        try {
			recordReader.initialize(test);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	    DataSetIterator testIter = new RecordReaderDataSetIterator(recordReader, batchSize, 1, outputNum);
	    // org.deeplearning4j.datasets.datavec.RecordReaderDataSetIterator.RecordReaderDataSetIterator(
	    //	RecordReader recordReader, int batchSize, int labelIndex, int numPossibleLabels)
	    
	    scaler.fit(testIter);
        testIter.setPreProcessor(scaler);
	    
	    Evaluation eval = new Evaluation(outputNum);
	    
		while(testIter.hasNext()){
	        DataSet next = testIter.next();
	        INDArray output = model.output(next.getFeatureMatrix());
	        
	        System.out.println(next.getLabels().toString());
	        
	        eval.eval(next.getLabels(),output);
	    }
	    
	    System.out.println(eval.stats());
		

		
		
		
		
		
		
		
		//System.out.println(endtime);
	
		//int[] arr = {9,2,1,13,5};
		
		//System.out.println("arr  = " + Arrays.toString(arr));
		
		//int[] quicksortedarr = quicksort(arr);
		
		//int[] sortedarr = mergesort(arr);
		
		
		//System.out.println("sortedarr  = " + Arrays.toString(sortedarr));
		

		
		//long timediff = endtime-starttime;
		//System.out.println(timediff);
		
		//System.out.print(globalcounter);
			
		
		
		
		//String inNumber = "2147483647";
		
		
		
		//String outNumber = nearestPalindrome(inNumber);
		//	3 digit = Loop Count = 19		20
		//	4 digit = Loop Count = 219		200
		//	5 digit = Loop Count = 199		200
		//	6 digit	= Loop Count = 2199		2000
		//	7 digit = Loop Count = 1999		2000
		//	8 digit = Loop Count = 1999		4000
		
		//	10 digit	2147483647	Loop Count = 72470	2147447412
		
		//	Odd
		//	111		121
		//	121		131
		//	131		141
		//	141		151
		//	171		181
		//	181		191
		//	191		181
		
		//	12421	12521
		//	13431	13531
		
		//	Even
		//	1221	1331
		//	1441	1551
		//	1881	1991
		//	1991	2002	
		
		//	134431	135531
		//	194491	195591
		
		//System.out.println(inNumber);
		//System.out.println(outNumber);
		//	121	
		//	122	+1
		//	120	-2
		//	
		
		/*
		
		try {	
			
			File file = new File(ClassLoader.getSystemResource("subset_male_actors.txt").getPath());
			
			System.out.println(file.getPath());
			
			Scanner s = new Scanner(file);
			
			while (s.hasNext()) {
				//1	word:Andy
				//2	word:Richter
				//3	word:5295
				//4	word:3050
				//5	word:http://s3.amazonaws.com/omgicu/celebrity_images/original_05f0b960d7844c3f2d9c0c0c36a6b07b.jpg
				//6	word:82,117,250,285
				//7	word:44547aae63c700b046e2dd7248e7df8726ade928c7f2c8688818a8548138629b
				
				//		name = parts[0]
				//	    image_id = int(parts[1])
				//	    face_id = int(parts[2])
				//	    url = parts[3]
				//	    bbox = list(map(int, parts[4].split(',')))  # This is a list of int
				//	    sha256 = parts[5]
				
			    //		Full images saved to datasetpath/images/name_image_id.ext
			    //		Face images saved to datasetpath/faces/name_image_id_face_id.ext
				//		# Output dir for images is datasetpath/images/name
				
				
				//if the word has a http:// in it then it is a URL and see if you can get the data form it.
				//If the URL is working then put it in a local directory
				
				String strFirstName = s.next();
				String strLastName = s.next();
				String strImageID = s.next();
				String strFaceID = s.next();
				String strURL = s.next();
				String strBBOX = s.next();
				String strSHA256 = s.next();
				
				System.out.println(	strFirstName + " " + 
									strLastName + " " + 
									strImageID + " " + 
									strFaceID + " " + 
									strURL + " " + 
									strBBOX + " " +
									strSHA256
				);
				
				//Data Validation
				
				URL website = null;
				try {
					website = new URL(strURL);
				} catch (MalformedURLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
					continue;
				}
				
				//Extract ImageFile name from the URL
				//Find the index of the last /
				int slashIndex = strURL.lastIndexOf("/");
				
				String strImageName = strURL.substring(slashIndex+1);
				System.out.println(strImageName);
				
				//Create folder "strFirstName strFirstName"
				//Path path = Paths.get("src/main/resources/" + strFirstName +" "+ strLastName);
				
				File mkdirFile = new File("src/main/resources/" + strFirstName +" "+ strLastName);
				boolean bmkdir = true;
				
				if (!file.exists())
				{
					bmkdir = new File("src/main/resources/" + strFirstName +" "+ strLastName).mkdir();
					
				}
				
				
				//Directory was created successfully or already exists
				File imageFile = null;
				if (bmkdir)
				{
				
					imageFile = new File(	"src/main/resources/" + 
												strFirstName + " " + 
												strLastName + 
												"/" + 
												strImageName);
					
					try {
						FileUtils.copyURLToFile(website, imageFile);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						continue;
					}
				}
				
				if (imageFile!=null)
				{	
					BufferedImage bi = null;
					try {
						bi = ImageIO.read(imageFile);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return;
					}
					if (bi!=null)	bi.flush();
				}
				
				//Create folder of "strFirstName strLastName"
				//If the image at URL exits then copy the image to the appropriate folder
					
				//System.out.println("word:" + s.next());
			    
				
			    //try {
				//	System.in.read();
				//} catch (IOException e) {
				//	// TODO Auto-generated catch block
				//	e.printStackTrace();
				//}
			    
			}
			
			s.close();
			
			// 	Run Deep Learning on the pictures
			// 	Delete the pictures which are corrupt
			// 	Problem - Point camera to the person and get the data from google 
			//	image search about the person. Get info from social media (Facebook, etc.)
			
			//	Create a Dataset of Machine Learning photos - male actors
			//	Create a Java Application which exposes a Java REST API interface using Apache Tomcat
			
			
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
			e.printStackTrace();
		}
		
		*/
		
		
		
	}

}
