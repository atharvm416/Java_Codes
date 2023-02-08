# Java_Codes
Contains Java with different style and formats
# 1. Bouncing Ball:
* The program is made up of multiple threads where, whenever the user creates a new object, an oval-shaped ball with a random colour is displayed on the screen. The ball or object will only move within the frame's size. The ball begins on the left side, moves along the left side, and bounces off the screen, which has a frame size of 600 by 600. To visualise it properly, "sleep" is used to pause the thread for a second, and its properties make it very easy to set the motion as well.
![Screenshot (613)](https://user-images.githubusercontent.com/112277897/217444230-ef5a42fe-a35f-49f1-864a-f98df7d965a2.png)
![Screenshot (614)](https://user-images.githubusercontent.com/112277897/217444240-27ae2b48-3b13-4047-9598-e3d01858ebf7.png)
![Screenshot (615)](https://user-images.githubusercontent.com/112277897/217444241-cfd5c72a-5556-4f98-aa45-06c6159130d2.png)
#2. Students record maintainence:
* The program contains the 'mypkg' package, from which we are using 'JOptionPane' methods to define a window directly. The data of the students is stored in the Stu2122.dat file. This file is accessed by using FileOutputStream and ObjectOutputStream & FileInputStream and ObjectInputStream to write and read. The programme has four main functions: adding, modifying, deleting, and displaying data.
![Screenshot (616)](https://user-images.githubusercontent.com/112277897/217444244-0bcf2f75-cf9b-4db0-b848-cbd726d052c1.png)
![Screenshot (617)](https://user-images.githubusercontent.com/112277897/217444245-3d39d499-b5c5-4ecd-8ea2-6abec11ee72a.png)
![Screenshot (618)](https://user-images.githubusercontent.com/112277897/217444247-e3ddd323-7893-4e76-8f11-6eeab5ba5bbe.png)
![Screenshot (619)](https://user-images.githubusercontent.com/112277897/217444345-7354892d-7a91-42e2-ad29-6fd8d84c0bf6.png)
![Screenshot (620)](https://user-images.githubusercontent.com/112277897/217444347-3bec3867-be13-459a-bd2a-1e724b60c9c9.png)
![Screenshot (621)](https://user-images.githubusercontent.com/112277897/217444348-4679db72-a790-4a8b-807b-cdbd88083447.png)
# 3. Server Client:
* The Server Client contains two Java files, one for the server side and another for the client side. First, we need to start our server by running the Server4.java file and then the Client4.java file. Note: Do not run the Client4.java file first; it will give an error. Both of the java files contain mostly similar types of coding. The Server4 contains ServerSocket, and the Client4 contains Socket, which will run on localhost at port 5051. It has a basic frame with a size of 400 by 400 in both files. 
![Screenshot (622)](https://user-images.githubusercontent.com/112277897/217444351-d98e13ba-191f-478a-86f7-595874371e02.png)
![Screenshot (623)](https://user-images.githubusercontent.com/112277897/217444356-9c55e1c1-a687-4e28-9057-e6e4c6999d0f.png)
![Screenshot (624)](https://user-images.githubusercontent.com/112277897/217444359-0ac09099-1c44-4612-bca0-9d8ca6e121b4.png)
# 4.Random Number generator Using RMI:
* The Random Number Generator Using RMI contains two Java files, one for the server side and another for the client side. First, we need to start our server by running the Server4.java file and then the Client4.java file. Note: Do not run the Client4.java file first; it will give an error. Run the server side as usual, but for the client side, use the lines below:
     ```
      * javac RMIClient1.java
      * RMIC Inter1Impl
      * start RMIClient1
      * java RMIClient1
     ```
We will now receive a new number each time we run Java RMIClient1. 
![Screenshot (625)](https://user-images.githubusercontent.com/112277897/217444361-d2f51e64-b0d9-49f8-9a20-7218387f2a61.png)
