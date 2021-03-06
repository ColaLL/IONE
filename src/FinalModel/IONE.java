package FinalModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

import ModelWith2OrderNorm.BasicUnit;
import StaticVar.Vars;

public class IONE {
	
	//network x as the foursquare, network y as the twitter 
	
	int foldtrain=9;
	
	public IONE(int foldtrain)
	{
		this.foldtrain=foldtrain;
	}
	
	public HashMap<String,String> getNetworkAnchors(String postfix_1,String postfix_2) throws IOException
	{
		HashMap<String,String> answer_map=new HashMap<String,String>();
		String file_name=Vars.twitter_dir+"twitter_foursquare_groundtruth/groundtruth."+this.foldtrain+".foldtrain.train.number";
		BufferedReader br=BasicUnit.readData(file_name);
		String temp_string=br.readLine();
		while(temp_string!=null)
		{
			answer_map.put(temp_string+postfix_1, temp_string+postfix_2);
			temp_string=br.readLine();
		}
		return answer_map;
	}
	
	
	public void Train(int total_iter,String fileInterop,int dim) throws IOException
	{

		String networkx_file=
				StaticVar.Vars.twitter_dir+"/foursquare/following"+fileInterop;
		String ouput_filename_networkx=
				StaticVar.Vars.twitter_dir+
				"/foursquare/embeddings/foursquare.embedding.update.2SameAnchor."+this.foldtrain+".foldtrain.twodirectionContext"+fileInterop;
		String networky_file=
				StaticVar.Vars.twitter_dir+"/twitter/following"+fileInterop;
		String ouput_filename_networky=
				StaticVar.Vars.twitter_dir+
				"/twitter/embeddings/twitter.embedding.update.2SameAnchor."+this.foldtrain+".foldtrain.twodirectionContext"+fileInterop;
		
		IONEUpdate twoOrder_x=
				new IONEUpdate(dim,networkx_file,"foursquare");
		twoOrder_x.init();
		
		IONEUpdate twoOrder_y=
				new IONEUpdate(dim,networky_file,"twitter");
		twoOrder_y.init();
		
		HashMap<String,String> lastfm_anchor=getNetworkAnchors("_foursquare","_twitter");
		HashMap<String,String> myspace_anchor=getNetworkAnchors("_twitter","_foursquare");
		System.out.println(lastfm_anchor.size());
		System.out.println(myspace_anchor.size());
		
		for(int i=0;i<total_iter;i++)
		{
			//TwoOrder.Train(i, total_iter);
			twoOrder_x.Train(i, total_iter, twoOrder_x.answer,
					twoOrder_x.answer_context_input,
					twoOrder_x.answer_context_output,
					lastfm_anchor);
			twoOrder_y.Train(i, total_iter, twoOrder_x.answer,
					twoOrder_x.answer_context_input,
					twoOrder_x.answer_context_output,
					myspace_anchor);
			if((i+1)%10000000==0)
			{
				twoOrder_x.output(ouput_filename_networkx+"."+dim+"_dim"+"."+(i+1));
				twoOrder_y.output(ouput_filename_networky+"."+dim+"_dim"+"."+(i+1));
			}
		}
		
		//TwoOrder.output(output_file_name);
	}
	public static void main(String[] args) throws IOException
	{
		for(int i=9;i>8;i--)
		{
			IONE test=
					new IONE(i);
			test.Train(10000000, ".number", 100);
		}
	}
	

}
