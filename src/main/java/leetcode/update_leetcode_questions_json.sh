#!/bin/bash

# Simulate the CURL response
RESPONSE=$(
curl 'https://leetcode.com/graphql/' \
-H 'accept: */*' \
-H 'accept-language: en-GB,en;q=0.7' \
-H 'authorization;' \
-H 'content-type: application/json' \
-H 'cookie: ip_check=(false, "49.207.235.56"); cf_clearance=_x_YUOjSll990yCaaEopLu3oQSy_JS5k_HQAqqCKXsw-1724040510-1.2.1.1-Z0bmShlIYBMNmujsdRIANIr11T5DJC4SMt31hBsAHda2QT97kkiuSC6iET7qvArlULAXgvpUN2jWUU0TvAHgAV5w8rr7QA97eU.8mc.3FcLsHC4c4YS3U6mRUaV7tl_ANTSYcMRaxfsM8DjbDyJvdVesRPByuATRiMcjXfrYHMQjZBIP8jd8qJDx_chGNRlU6xWcqmlbtfmXSicaGpiusnMwYg1OHHVbkaoLEwLEiyL9s0Tm7HqdMa__Kq3dAt0FI7pAk9bXmzrM9Y3OWNz2E0Vkp9p1_FuE0HF9OyFqQsM2aEMfGqcM6NNX7JbWdqdpINECzOj4FWdnbFvqGMWJJ9NtutS.I9JUYpOthTn9bTic3X3hMvZxpF8X1z32I7_qHN1VGFCmZi2zGEUu8uRD3E8dgA8P.FB1p93xlihnw2A; csrftoken=tZJKhkmhsO9MbdxXt9fK6W1IF1gei7NDDxkU1l2qQIaUyB8OyQu93dm4Recpt1Dg; messages=.eJyLjlaKj88qzs-Lz00tLk5MT1XSMdAxMtVRCi5NTgaKpJXm5FQqFGem56WmKGTmKSQWKzgmZWTmJuZVlhqa6CnF6owaMGrAqAGjBowaMGrAqAGjBlDbgFgAAorwpw:1sfth5:zYRJpaxbjE8hD2FtkYw1_L3CwvXNa1zRg7VJYNDLUbk; LEETCODE_SESSION=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJfYXV0aF91c2VyX2lkIjoiMzQ0MTUwMyIsIl9hdXRoX3VzZXJfYmFja2VuZCI6ImFsbGF1dGguYWNjb3VudC5hdXRoX2JhY2tlbmRzLkF1dGhlbnRpY2F0aW9uQmFja2VuZCIsIl9hdXRoX3VzZXJfaGFzaCI6ImU1YjI3YjUyZWU4NGFiZTE3ZTVmZTZmYmFiODM5NDFlMTk2NDM4MzUzMThkMzhhZWNkYzNjNmJjOGE2OTliZGUiLCJpZCI6MzQ0MTUwMywiZW1haWwiOiJhYmhpbWFueXUubjE0QGdtYWlsLmNvbSIsInVzZXJuYW1lIjoiQWJoaW1hbnl1MTQiLCJ1c2VyX3NsdWciOiJBYmhpbWFueXUxNCIsImF2YXRhciI6Imh0dHBzOi8vYXNzZXRzLmxlZXRjb2RlLmNvbS91c2Vycy9hdmF0YXJzL2F2YXRhcl8xNzAyMDQ4MTgzLnBuZyIsInJlZnJlc2hlZF9hdCI6MTcyNDA0MDUxNSwiaXAiOiI0OS4yMDcuMjM1LjU2IiwiaWRlbnRpdHkiOiI2YTIzNzc1NzI5ZmQ2YzA2OGQyMGQzODNjYmUyN2Y5YiIsImRldmljZV93aXRoX2lwIjpbIjhmMjdhMjNhN2Y0MmFkNmZmNDJjMmFmMWNmY2JkYTk0IiwiNDkuMjA3LjIzNS41NiJdLCJzZXNzaW9uX2lkIjo2OTU0NDgyNywiX3Nlc3Npb25fZXhwaXJ5IjoxMjA5NjAwfQ.eXrDx0I0eiuJFPQwrdKwWdUQs4YgxU5UtPI7RRvz19A; INGRESSCOOKIE=b4342c1e15d60d4aedd8b0f4ecdf78b3|8e0876c7c1464cc0ac96bc2edceabd27; __cf_bm=qZ.stNENZOm9pDbapqKCbADlziSuBElnjPE9.m4t9TI-1724041536-1.0.1.1-gKy2rts0WRMFnbs67Yyb140Mkt7cuRYbDFKEte.OaLF7tYrs4yEAxUffG.2QJ5IvnKNA2ZiG4Q9CBqpfuE.awA; __stripe_mid=fa8a4bd9-a770-4663-9c10-8989972b9450bfb148; __stripe_sid=7e5a95d0-4e32-4da7-a264-a2095cb9c911de08b4; c_a_u="QWJoaW1hbnl1MTQ=:1sfu07:dQi_ASEQk-bUngzYDy4iSs2QXGgf8re0Sx0gAP8jNeY"' \
-H 'origin: https://leetcode.com' \
-H 'priority: u=1, i' \
-H 'random-uuid: 29d40264-17cd-8ec2-1151-e0a5e5b38f34' \
-H 'referer: https://leetcode.com/problemset/?page=2' \
-H 'sec-ch-ua: "Not)A;Brand";v="99", "Brave";v="127", "Chromium";v="127"' \
-H 'sec-ch-ua-mobile: ?0' \
-H 'sec-ch-ua-platform: "macOS"' \
-H 'sec-fetch-dest: empty' \
-H 'sec-fetch-mode: cors' \
-H 'sec-fetch-site: same-origin' \
-H 'sec-gpc: 1' \
-H 'user-agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.0.0 Safari/537.36' \
-H 'uuuserid: 8f27a23a7f42ad6ff42c2af1cfcbda94' \
-H 'x-csrftoken: tZJKhkmhsO9MbdxXt9fK6W1IF1gei7NDDxkU1l2qQIaUyB8OyQu93dm4Recpt1Dg' \
--data-raw '{"query":"\n    query problemsetQuestionList($categorySlug: String, $limit: Int, $skip: Int, $filters: QuestionListFilterInput) {\n  problemsetQuestionList: questionList(\n    categorySlug: $categorySlug\n    limit: $limit\n    skip: $skip\n    filters: $filters\n  ) {\n    questions: data {\n      frontendQuestionId: questionFrontendId\n      title\n      titleSlug\n      }\n  }\n}\n    ","variables":{"categorySlug":"all-code-essentials","skip":0,"limit":5000,"filters":{}},"operationName":"problemsetQuestionList"}'
)

# Extract the "questions" array using jq
QUESTIONS=$(echo "$RESPONSE" | jq '.data.problemsetQuestionList.questions')

# Print the extracted array
echo "$QUESTIONS"  | jq > ./leetcode_questions.json
