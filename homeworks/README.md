These are the homeworks for columbia COMS3137.

Students should follow the following workflow for using this repo

1. Fork the repo
2. Clone from the CURG org with git clone git@github.com:CURG/COMSW3137.git
3. Add your repo as a remote: git remote add myuser git@github.com:USERNAME/COMS3137.git
4. Fill out the user_info.txt in this repo. 
5. Do your homework and commit it.
6. Push your homework to your repo: git push myuser


When the main CURG repo is updated, you will need to pull and merge those changes.
The standard way of doing this is git pull, but we are going to try to do things using a different method: Rebasing. 

First, read this:
https://adamcod.es/2014/12/10/git-pull-correct-workflow.html

1. Get the most recent updates: git fetch origin
2. Check if there are any changes: git status
3. If there are changes, try to fetch and rebase on to them: git fetch origin --prune
5. git merge --ff-only origin/master
7. git rebase --preserve-merges origin/branch-name
8. If that changes, you may need to merge the changes: git merge
9. This may fail. If it does, try googling your problem, and then contact a TA. 
10. git push username master:master
11. If this fails, you may need to do git push -f master:master -- This is dangerous and will overwrite your remote repo. 
