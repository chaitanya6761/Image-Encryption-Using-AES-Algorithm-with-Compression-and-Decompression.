/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CCosmoCompressor;
import java.io.*;
import FileBitIO.CFileBitWriter;

/**
 *
 * @author Sony
 */
public class CCosmoEncoder implements cosmoInterface {
    private String fileName,outputFilename;
	private long[] freq  = new long[MAXCHARS];
	private String[] hCodes = new String[MAXCHARS];
	private int distinctChars = 0;
	private long fileLen=0,outputFilelen;
	private FileInputStream fin;
	private BufferedInputStream in;	
	

	
	void resetFrequency(){
		for(int i=0;i<MAXCHARS;i++){
		hCodes[i] = "";
		freq[i] = 0;
		}
		distinctChars = 0;
		fileLen=0;
		
		}
	
	public CCosmoEncoder (){
		loadFile("","");
		}
	public CCosmoEncoder (String txt){
		loadFile(txt);
		}
	public CCosmoEncoder (String txt,String txt2){
		loadFile(txt,txt2);
		}
		
	public void loadFile(String txt){
		fileName = txt;
		outputFilename = txt + strExtension;
		resetFrequency();
		}
	public void loadFile(String txt,String txt2){
		fileName = txt;
		outputFilename = txt2;
		resetFrequency();
		}
	public boolean encodeFile() throws Exception{
		
		if(fileName.length() == 0 ) return false;
		
		try{
			fin = new FileInputStream(fileName);
			in = new BufferedInputStream(fin);
		}catch(Exception e){ throw e; }
		
		//Frequency Analysis
  		try
		{
			fileLen = in.available();
			if(fileLen == 0) throw new Exception("File is Empty!");
			
			
			long i=0;

			in.mark((int)fileLen);
			distinctChars = 0;
			
			while (i < fileLen)
			{		
				int ch = in.read();			
				i++;
				if(freq[ch] == 0) distinctChars++;
				freq[ch]++;
				
			}
			in.reset();			
		}
		catch(IOException e)
		{
			throw e;
			//return false;
		}
		
		
		
		if(distinctChars > 128 || distinctChars == 0) throw new Exception("\nCosmo Compression Not Possible!\n");
		
		int nMaxbits=2,nBits=1;
		while(nMaxbits <= distinctChars){
			nMaxbits *= 2;
			nBits++;
		}

		if(nBits >= 8) return false;
		
		
		//build Codes
		int Code=0;
		for(int i=0;i<MAXCHARS && Code < distinctChars;i++){
			if(freq[i] > 0){
				hCodes[i] = leftPadder(Integer.toString(Code++,2),nBits);
				//System.out.println((char) i + " : " + hCodes[i]);
				}
			}
			
			
		
		CFileBitWriter hFile = new CFileBitWriter(outputFilename);
				
		hFile.putString(cosSignature);
		String buf;
		buf = leftPadder(Long.toString(fileLen,2),32); //fileLen
		hFile.putBits(buf);
		buf = leftPadder(Integer.toString(distinctChars,2),8); //No of Encoded Chars
		hFile.putBits(buf);
		
		int count = 0;
		for(int i=0;i<MAXCHARS && count < distinctChars;i++){
			if(freq[i] > 0){
				buf = leftPadder(Integer.toString(((char)i),2),8);
				hFile.putBits(buf);
				count++;
				}
			}
		
		long lcount = 0;
		while(lcount < fileLen){
			int ch = in.read();
			hFile.putBits(hCodes[(int)ch]);
			lcount++;
		}

		hFile.closeFile();
		outputFilelen =  new File(outputFilename).length();
		float cratio = (float)(((outputFilelen)*100)/(float)fileLen);
		
		
		return true;
	
	}

	String leftPadder(String txt,int n){
		while(txt.length() < n )
			txt =  "0" + txt;
		return txt;
		}
	
	String rightPadder(String txt,int n){
		while(txt.length() < n )
			txt += "0";
		return txt;
		}
		
	

    
    
    
    
}
