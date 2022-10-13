# if there isn't a bin folder, make one
[ ! -d bin/ ] &&  mkdir bin/

# run the java compiler
javac src/*.java -d bin/ 

# cd into the binary folder
cd bin/

# run the main class
java StoreSim

# for windows: make sure it stays open
read -p "Program finished. Enter to escape: "
