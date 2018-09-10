# Jupyter Lab for Clojurians

A Docker container for data science with Python and Clojure. 
Includes Anaconda, BeakerX and Leiningen. 

Versions at the time of writing are Ubuntu 18.04, 
Anaconda 5.2 and BeakerX 1.1.0. 

## Host-side 

Edit `project.clj` to include your choice of clojure 
dependencies for Leiningen.

Edit/adapt the three host-side scripts to match your preferences
of image name, port mapping, local data directory and favourite 
browser (below: Chrome in application mode on Windows).

```shell
# docker-build.bat
docker build -t belove/jupyterlab . %

# docker-run.bat
docker run -e "LAB_PORT=55000" -p 55000-55010:55000-55010 --name %1 -v %2:/root/data belove/jupyterlab:latest %

#docker-connect.bat
"C:\Program Files (x86)\Google\Chrome\Application\chrome.exe" --app=http://localhost:55000/?token=%1
```

Build, run and connect:

```shell
# Build the image belove/jupyterlab 
.\docker-build

# Run the image with container name and local data directory
 .\docker-run jupyterlab D:\data
 
# Read the jupyter token and open jupyterlab as standalone app in Chrome
docker logs jupyterlab --tail 50
docker-connect
docker-connect <token>
```

## Container-side

Use `exec -ti <container> bash` on the host to start a 
new root shell session on the container and start a new 
jupyter notebook, lab or clojure REPL:

```shell
# start a jupyter notebook/lab or the Leiningen RPEL on port 56789
notebook 56789
lab 56789
repl 56789
```

The above scripts start Jupyter and the REPL on public ports. 
You should amend the Dockerfile and restrict access 
(e.g. authorised IPs or ssh) if the container lives 
in an open environment.

## License

Copyright © 2018 Nicolas Duchenne, [Belove Ltd](https://www.belove.co.uk), London, UK

Distributed under the 
[Creative Commons Attribution 4.0 (CC BY 4.0)](https://creativecommons.org/licenses/by/4.0/) 
license.
