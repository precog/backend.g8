# backend g8 template

```bash
$ sbt new precog/backend.g8
```

You will be prompted for the following:

- `name [Your Project Name]:`
- `open_source [false]:`

Answer the questions. Let's assume the project name is `Foo Bar`. There will be a new project created in `./foo-bar/`:

```bash
$ cd foo-bar
$ git init
$ git add .
$ git commit -S -m 'Initial commit'
$ ./sbt githubWorkflowGenerate
$ git add .
$ git commit -S -a --amend -m 'Initial commit'
$ git remote add upstream git@github.com:precog/foo-bar.git
# create repo on github (see below)
$ git push upstream master
```

Note the workflow generation stage. This is very important, otherwise your project will not build!

Once this is done, the only remaining step is to add the GitHub Actions secret for `ENCRYPTION_PASSWORD`. You can find the value for this in 1Password under the **Build Encryption Password** entry. Please note that there are no typos in this value, and you should just copy it exactly verbatim.

To add the secret, go to the **Secrets** section of your repository settings, click **Add a new secret**, enter `ENCRYPTION_PASSWORD` for the name and paste the value into the text box. Then click **Add secret** and you're all set! Run `git push upstream master` and the first Actions build should run!

## Repository Creation

[Click here](https://github.com/organizations/precog/repositories/new). Put in the appropriate name and description and go to town. Go into **Settings** and disable **Wiki** and **Issues**. Once this is done, go to **Manage Access**, enter your password, and add the **Engineering** team as an **Admin** on the repository (publication will fail without this step!).

## Labels and Publication

Unless you're writing an sbt plugin, published artifacts will be made available under the **Packages** section of your repository. After a short delay, they are also mirrored under the same section of the Precog organization. Once your first successful build has completed and the repository has published, you *must* use the `sdmerge` script and pull requests! This is not optional.
