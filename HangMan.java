import java.util.Scanner;
import java.util.Random;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HangMan{
static int falseEntry=0;
static boolean gameContinue=true;
static boolean replay=true;
static boolean found=false;
static String originalWord;
static char guess;
static String fileN;
public static void guessedWord(String guess){
	if(guess.equals(originalWord)){
	found=true;}
	else{System.out.println("Wrong guess!");}}
public static String selectFile(Scanner input){
System.out.println("Select a topic to play");
System.out.println("1-countrys, 2-oscar winners(films and men winners),3-old school rappers");
int select=input.nextInt();
input.nextLine();
switch(select){
	case 1:
	return "words.txt";
	case 2:
	return "films.txt";
	case 3:
	return "rappers.txt";
	}
	return "a";
	}
public static String wordCencor(String word){
String CenWord="";
	for(int i=0;i<word.length();i++){
	CenWord=CenWord+"-";}
	return CenWord;}
public static String revealChar(char c,String word,String cencor){
String cha=c+"";
originalWord=word;
	if(word.contains(cha)){
	while(word.contains(cha)){
		cencor=cencor.substring(0,word.indexOf(c))+c+cencor.substring(word.indexOf(c)+1);
		word=word.replaceFirst(cha,"-");}
		System.out.println(cencor);
		return cencor;}
	else{
	System.out.println("no chars as guessed");
	System.out.println(cencor);
	falseEntry++;
	if(falseEntry==7){
	System.out.println("You have lost!");
	System.out.println(originalWord);
	hangManDrawings();
	gameContinue=false;}
	else{
	System.out.println("You guessed wrong"+falseEntry+"/7");
	hangManDrawings();}
		return cencor;}
		}
public static String[] createWord(String filename){
try{
Scanner file=new Scanner(new FileInputStream(filename));
int count=0;
if(!file.hasNextLine()) System.out.println("File Is Empty");
while(file.hasNextLine()){
	file.nextLine();

	count++;}
	file.close();
String[] words=new String[count];
Scanner file2=new Scanner(new FileInputStream(filename));
if(!file2.hasNextLine()) System.out.println("File Is Empty");
for(int a=0;file2.hasNextLine();a++){
	words[a]=file2.nextLine().toLowerCase();}
	file2.close();
	return words;
}catch(FileNotFoundException e){
	System.out.println(e.getMessage());
	return new String[0];}
}
public static void hangManDrawings(){
	switch(falseEntry){
		case 0:
		break;
		case 1:
		System.out.println("___");
		System.out.println(" |");
		System.out.println(" O");
		break;
		case 2:
		System.out.println("___");
		System.out.println(" |");
		System.out.println(" O");
		System.out.println(" |");
		break;
		case 3:
		System.out.println("___");
		System.out.println(" |");
		System.out.println(" O");
		System.out.println("\\|/");
		break;
		case 4:
		System.out.println("___");
		System.out.println(" |");
		System.out.println(" O");
		System.out.println("\\|/");
		System.out.println(" |");
		break;
		case 5:
		System.out.println(" ___");
		System.out.println("  |");
		System.out.println("  O");
		System.out.println(" \\|/");
		System.out.println("  |");
		System.out.println("./ \\.");
		break;
		case 6:
		System.out.println(" ___");
		System.out.println("  |");
		System.out.println("  O");
		System.out.println("   \\");
		System.out.println("  \\|/");
		System.out.println("   |");
		System.out.println(" ./ \\.");
		break;
		case 7:
		System.out.println(" ___");
		System.out.println("  |");
		System.out.println("  O");
		System.out.println("  .");
		System.out.println(" \\|/");
		System.out.println("  |");
		System.out.println("./ \\.");
		break;
		}}
public static void main(String[] args){
while(replay){
found=false;
Random ran=new Random();
Scanner input=new Scanner(System.in);
fileN=selectFile(input);
String[] words=createWord(fileN);
String ranWord=words[ran.nextInt(words.length)];
String cencorWord=wordCencor(ranWord);
System.out.println(cencorWord);
while(!found&&gameContinue){
	System.out.println("Make a guess");
	System.out.println("if you want to guess space write '0'");
	String guessAll=input.nextLine().toLowerCase();
	if(guessAll.length()==1){
		guess=guessAll.charAt(0);}
	else{
	guessedWord(guessAll);}
	cencorWord=revealChar(guess,ranWord,cencorWord);
	if(!cencorWord.contains("-")){
		found=true;
		System.out.println("Found!");}}
System.out.println("If you want to exit press x");
if(input.next().equalsIgnoreCase("x")) replay=false;
else{replay=true; falseEntry=0; gameContinue=true; found=false;}}
}
}
