# backend g8 template [![Build Status](https://travis-ci.org/slamdata/backend.g8.svg?branch=master)](https://travis-ci.org/slamdata/backend.g8)

```bash
$ sbt new slamdata/backend.g8
```

You will be prompted for the following:

- `name [Your Project Name]:`
- `open_source [no]:`

Answer the questions. Let's assume the project name is `Foo Bar`. There will be a new project created in `./foo-bar/`:

```bash
$ cd foo-bar
$ git init
$ git commit -Sm 'Initial commit'
$ git remote add upstream git@github.com:slamdata/foo-bar.git
# create repo on github (see below)
$ git push upstream master
$ travis enable -r slamdata/foo-bar.git
```

Once this is done, the only remaining step is to [`travis encrypt`](https://docs.travis-ci.com/user/encryption-keys/#Usage) the following variables and add them to the `env.global` section of the `.travis.yml`:

- `ENCRYPTION_PASSWORD` Find this in 1Password
- `GITHUB_TOKEN` Create a new personal OAuth token for the **slamdata-bot** account (credentials in 1Password)
- `GITHUB_ACCESS_TOKEN` See above
- `DISCORD_WEBHOOK_TOKENS` Go into Discord. Select the cog next to the **#github** channel, then choose **Webhooks** and then **Edit**. This variable should be set to the value which *follows* the `https://discordapp.com/api/webhooks/` url prefix.

Once those secure sections have been created (preserve the labeling comments, please), run `git push upstream master` and the first Travis build should run!

## Repository Creation

[Click here](https://github.com/organizations/slamdata/repositories/new). Put in the appropriate name and description and go to town. Go into **Settings** and disable **Wiki** and **Issues**. Once this is done, go to **Collaborators and Teams**, enter your password, and add the **Engineering** team as an **Admin** on the repository (publication will fail without this step!).

## Labels and Publication

Publication will be automatically enabled for your repository. You are thus expected to use the `sdmerge` script and a pull request workflow. You will need to create the following four labels on your repository:

- **version: release**
- **version: breaking**
- **version: feature**
- **version: revision**

The **version: release** label is no longer necessary once you have passed version **1.0.0**.

Once your first successful Travis build has completed, you *must* use the `sdmerge` script and pull requests! This is not optional.
