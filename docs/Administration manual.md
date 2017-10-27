Administration manual
=====================

### What is needed to build
> * [Gradle 4.2.1](https://gradle.org/install/) - Installation guide
> * [Java Development Kit 8](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html) - Installation guide
> * [Git 2.14.3](https://git-scm.com/downloads) - Download link

### How to deploy, run and maintain
in case of client/server or web application
> ## How to deploy
> * git command "  ".
> ## How to run
> * git command "gradle build run" or "gradle run".
> ## How to maintain
> * Make a pull request to github by pushing a finished feature on a branch to origin/master with git command "git push -u origin <branchName>".
> * From github repository make a pull request on branches with features that need to be deployed, this is linked to [Travis](https://travis-ci.org/). If travis build goes through green go to next step. If it goes red start over with a new pull request with corrected source code.
> * From github repository access the pull request that should now be accepted by [Travis](https://travis-ci.org/) and merge pull request.



