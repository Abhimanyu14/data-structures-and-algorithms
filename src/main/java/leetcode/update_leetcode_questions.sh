#!/bin/bash

# Change to the directory where the script is located
cd "$(dirname "$0")"

./update_leetcode_questions_json.sh

# Define JSON file path
JSON_FILE="./leetcode_questions.json"

# Check if jq (JSON parser) is installed
if ! command -v jq &> /dev/null; then
    echo "Error: jq is not installed. Please install it and try again."
    exit 1
fi

# Parse the JSON and extract the required fields
generate_directory_name() {
    local id=$1
    local slug=$2
    echo "leetcode_${id}_${slug//-/_}"
}

# Create the solution file content
generate_solution_file_content() {
    local package_name=$1
    local slug=$2
    local difficulty=$3
    cat <<EOF
package leetcode.${package_name}

/**
 * leetcode - https://leetcode.com/problems/${slug}/
 *
 * TODO(Abhi) - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty - ${difficulty}
 *
 * Stats
 *
 * Time -
 * Space -
 *
 * Companies -
 */
private fun main() {

}
EOF
}


# Parse the JSON file and create missing directories and Solution.kt files
count=0
while IFS=$'\t' read -r id titleSlug difficulty; do
    if [[ -z "$id" || -z "$titleSlug" ]]; then
        continue
    fi
    
    dir_name=$(generate_directory_name "$id" "$titleSlug")
    
    if [ ! -d "$dir_name" ]; then
        mkdir -p "$dir_name"
        echo "Created directory: $dir_name"

        solution_file="$dir_name/Solution.kt"
        generate_solution_file_content "$dir_name" "$titleSlug" "$difficulty" > "$solution_file"
        echo "Created file: $solution_file"
        ((count++))
    fi
done < <(jq -r '.[] | "\(.frontendQuestionId)\t\(.titleSlug)\t\(.difficulty)"' "$JSON_FILE")

if [ $count -eq 0 ]; then
    echo "All directories are already up to date."
else
    echo "Successfully updated $count new questions."
fi
