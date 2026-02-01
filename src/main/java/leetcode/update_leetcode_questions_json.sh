#!/bin/bash

# Fetch all questions from LeetCode API
RESPONSE=$(curl -s 'https://leetcode.com/api/problems/all/')

# Extract the required fields and transform to the desired JSON format
# Note: frontend_question_id is converted to frontendQuestionId, etc.
QUESTIONS=$(echo "$RESPONSE" | jq '[.stat_status_pairs[] | {frontendQuestionId: .stat.frontend_question_id | tostring, title: .stat.question__title, titleSlug: .stat.question__title_slug}] | sort_by(.frontendQuestionId | tonumber)')

# Print the extracted array to the JSON file
echo "$QUESTIONS" | jq > ./leetcode_questions.json
