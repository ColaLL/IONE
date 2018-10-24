# IONE
Source Code and anonymous twitter_foursquare data for IJCAI 2016 paper "Aligning Users Across Social Networks Using Network Embedding"

<b>With the permission of sharing anonymous twitter_foursquare data from Prof.Jiawei Zhang, we share the anonymous data and code of IONE here. If you use the data and code of this project, please cite the following three papers. Note that the data and code only can be used for research purposes</b>

@inproceedings{zhang2015integrated,<br>
  title={Integrated Anchor and Social Link Predictions across Social Networks.},<br>
  author={Zhang, Jiawei and Philip, S Yu},<br>
  booktitle={IJCAI},<br>
  pages={2125--2132},<br>
  year={2015}<br>
}<br>

@article{DBLP:journals/corr/abs-1804-09874,<br>
  author    = {Jiawei Zhang},<br>
  title     = {Social Network Fusion and Mining: {A} Survey},<br>
  journal   = {CoRR},<br>
  volume    = {abs/1804.09874},<br>
  year      = {2018},<br>
  url       = {http://arxiv.org/abs/1804.09874},<br>
  archivePrefix = {arXiv},<br>
  eprint    = {1804.09874},<br>
  timestamp = {Mon, 13 Aug 2018 16:47:39 +0200},<br>
  biburl    = {https://dblp.org/rec/bib/journals/corr/abs-1804-09874},<br>
  bibsource = {dblp computer science bibliography, https://dblp.org}<br>
}<br>

@inproceedings{liu2016aligning,<br>
  title={Aligning Users across Social Networks Using Network Embedding.},<br>
  author={Liu, Li and Cheung, William K and Li, Xin and Liao, Lejian},<br>
  booktitle={IJCAI},<br>
  pages={1774--1780},<br>
  year={2016}<br>
}<br>

When running the code, firstly check the Vars.java to make sure that the path of the data is correct. New two folds which are named as "embeddings" in foursquare fold and twitter fold.

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
   			


<!-- groundtruth.test.linkp.x, the soft constraint file, which is predicted by a classifier. Only for the IONES model. Where x is the imbalance ratio of training classifier -->


There are four models of our paper, INE, ONE , IONE and IONE-S

For the INE and ONE, run the INE.java. If you run the INE model, use "test.Train(10000000, "", 100);". For ONE model, reverse the relationship between users for a new following file, then run the INE.java.
<!--modify the code as "test.Train(10000000, ".reverse", 100);".-->

For the IONE, run the IONE.java.

<!--For the IONES, run the IONES.java-->

<!--If you want to test the performance of the models with different interops, add the postfix to the Train function. For example,
"test.Train(10000000, ".0.1", 100);".-->

We will add the IONES model with anonymous data as soon as possible.

All the embeddings in the embedding directory of foursquare and twitter.

The getPrecision.java is used for p@1-p@30 calculation of our model。

Feel free to contact me (Liu Li liuli0407@hotmail.com) when you have any problems about the paper or the code. 
