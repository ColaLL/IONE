# AcrossNetworkEmbedding
Source Code and Synthetic data for IJCAI 2016 paper "Aligning Users Across Social Networks Using Network Embedding"

<b>Note that as we are not the dataset owners, it is the across network embedding code with Synthetic dataset. If you can ask for the dataset permission of the author of paper IJCAI 15 paper "Integrated Anchor and Social Link Predictions across Partially Aligned Social Networks", we can share a complete version with all pre-preparation data.</b>

When running the code, firstly check the Vars.java to make sure that the path of the data is correct.  New two folds which are named as "embeddings" in foursquare fold and twitter fold.

Description of Data directory

   AcrossNetworkEmbeddingData
   
   		foursquare:
   		
   			following: the relation file, "1  2" means user 1 is the follower of user 2.  			   			
   			following.reverse: the reverse relation file, for model which considers only one direction context. ONE model.
   			
   		twitter:
   		
   			the same as the foursquare fold
   			
   		twitter_foursquare_groundtruth:
   		
   			groundtruth: the groundtruth for our experiment, the anchor users between twitter and foursquare. 
   			Note that pls make the anchors as the *same* id during the pre-preparation, 
   			although the testing anchors will have the same id, 
   			they will *not* take part in the training progress as they are not contained in the groundtruth.x.foldtrain.train file.	
   			
   			groundtruth.x.foldtrain.train, the traning anchors, which are the 0.x of all the anchors.
   			
   			groundtruth.x.foldtrain.test,  the testing anchors, which are the 1-0.x of all the anchors.
   			
   			groundtruth.test.linkp.x, the soft constraint file, which is predicted by a classifier. Only for the IONES model. Where x is the imbalance ratio of training classifier
   			

There are four models of our paper, INE, ONE , IONE and IONE-S

For the INE and ONE, run the INE.java. If you run the INE model, just use "test.Train(10000000, "", 100);", for ONE model,
modify the code as "test.Train(10000000, ".reverse", 100);".

For the IONE, run the IONE.java.

For the IONES, run the IONES.java

If you want to test the performance of the models with different interops, add the postfix to the Train function. For example,
"test.Train(10000000, ".0.1", 100);".

All the embeddings in the embedding directory of foursquare and twitter.

The getPrecision.java is used for p@1-p@30 calculation of our model。

Feel free to contact me (Liu Li liuli0407@hotmail.com) when you have any problems about the paper or the code. 
