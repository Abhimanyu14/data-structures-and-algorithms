#!/bin/bash

./update_leetcode_questions_json.sh

# Define root directory and JSON file path
ROOT_DIR="."
JSON_FILE="$ROOT_DIR/leetcode_questions.json"

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
    cat <<EOF
package leetcode.${package_name}

/**
 * leetcode -
 *
 * TODO - To revisit
 *
 * Data Structure -
 * Algorithm -
 *
 * Difficulty -
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

# Read existing directory names
existing_directories=()
while IFS= read -r dir; do
    existing_directories+=("$dir")
done < <(find "$ROOT_DIR" -mindepth 1 -maxdepth 1 -type d -exec basename {} \;)

# Parse the JSON file
new_directories=()
while IFS=$'\t' read -r id titleSlug; do
    dir_name=$(generate_directory_name "$id" "$titleSlug")
    new_directories+=("$dir_name")
done < <(jq -r '.[] | "\(.frontendQuestionId)\t\(.titleSlug)"' "$JSON_FILE")

# Create missing directories and Solution.kt files
for dir_name in "${new_directories[@]}"; do
    if [[ ! " ${existing_directories[*]} " =~ " ${dir_name} " ]]; then
        new_dir="$ROOT_DIR/$dir_name"
        mkdir -p "$new_dir"
        echo "Created directory: $new_dir"

        solution_file="$new_dir/Solution.kt"
        generate_solution_file_content "$dir_name" > "$solution_file"
        echo "Created file: $solution_file"
    fi
done

echo "All directories are up to date."
