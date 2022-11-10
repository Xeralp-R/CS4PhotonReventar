# if there isn't a bin folder, make one
[ ! -d bin/ ] &&  mkdir bin/

# run the java compiler
cd src/

find -type f -exec javac {} -d ../bin/ \;

#javac src/*.java -d bin/ 

# cd into the binary folder
cd ../bin/

# run the main class
java App

# for windows: make sure it stays open
read -p "Program finished. Enter to escape: "
