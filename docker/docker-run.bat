docker run -e "LAB_PORT=55000" -p 55000-55010:55000-55010 --name %1 -v %2:/root/data belove/jupyterlab:latest %