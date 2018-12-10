for f in *.txt; do 
    mv -- "$f" "${f%.txt}.java"
done