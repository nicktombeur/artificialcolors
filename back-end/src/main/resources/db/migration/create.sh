#!/bin/bash

echo "File name: "
read -r file_description

NOW=$(date +"%Y%m%d%H%M%S")
FILE_NAME="V${NOW}__${file_description}.sql"

touch "$FILE_NAME"
git add "$FILE_NAME"
