Administration manual
=====================

### What is needed to build 
> 
> ## Install
> * [Gradle 4.2.1](https://gradle.org/install/) - Installation guide
> * [Java Development Kit 8](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html) - Installation guide
> After installing gradle and JDK 8 on your current system the PATH needs to be set [Guide](https://www.java.com/en/download/help/path.xml)
> * [Git 2.14.3](https://git-scm.com/downloads) - Download link
> ## Build
> * Need to clone the repository from [TeamCaps](https://github.com/HUGB2017TeamCapslock/TeamCaps) and get permission see Source control client below.
> * In git, run gitbash in a fresh directory and run the command "git clone git@github.com:HUGB2017TeamCapslock/TeamCaps.git", this will clone the current master of the repository on your pc. 
> * To build run the command "gradle build" this will build the project on your own staging, make sure to make a new feature branch before making any changes to the current build.

### How to deploy, run and maintain
in case of client/server or web application
> ## How to deploy
> * By merging a feature branch with master travis automaticly deploys the new master. Git command "git push -u origin <feature branch name>"
> ## How to run
> * git command "gradle run" to run locally, othervice the current deployment is at [Site](https://dry-bastion-22033.herokuapp.com/)
> ## How to maintain
> * Make a pull request to github by pushing a finished feature on a branch to origin/master with git command "git push -u origin <branchName>".
> * From github repository make a pull request on branches with features that need to be deployed, this is linked to [Travis](https://travis-ci.org/). If travis build goes through green go to next step. If it goes red start over with a new pull request with corrected source code.
> * From github repository access the pull request that should now be accepted by [Travis](https://travis-ci.org/) and merge pull request.

