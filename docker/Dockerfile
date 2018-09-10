# Portable development environment
#
# VERSION 0.1.0

FROM ubuntu:18.04

MAINTAINER Nicolas Duchenne <hello@belove.co.uk>

# apt packages
RUN apt-get update
RUN apt-get install -y wget net-tools lsof

# anaconda distribution
RUN wget -q https://repo.anaconda.com/archive/Anaconda3-5.2.0-Linux-x86_64.sh -O /root/anaconda.sh && \
    bash /root/anaconda.sh -b -p /root/anaconda
ENV PATH /root/anaconda/bin:$PATH

# conda packages
RUN conda install -y -c defaults -c conda-forge nodejs beakerx jaydebeapi openjdk

# BeakerX extensions to Jupyter Lab
RUN jupyter labextension install @jupyter-widgets/jupyterlab-manager && \
    jupyter labextension install beakerx-jupyterlab

# pip packages
RUN pip install --upgrade pip

# leiningen
RUN mkdir -p /root/bin && \
    wget -q https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein -O /root/bin/lein && \
    chmod 755 /root/bin/lein

# clojure dependencies
ENV PATH /root/bin:$PATH
COPY project.clj /root/clojure/
WORKDIR /root/clojure/
RUN lein deps

# scripts
WORKDIR /root/bin/
RUN echo '#!/bin/bash \n export JAVA_HOME=$(find /root/anaconda/pkgs -name openjdk* -type d | tail -n 1)' > setenv && \
    echo '#!/bin/bash \n source setenv \n jupyter notebook --ip=0.0.0.0 --port=$1 --no-browser --allow-root' > notebook && \
    echo '#!/bin/bash \n source setenv \n jupyter lab --ip=0.0.0.0 --port=$1 --no-browser --allow-root' > lab && \
    echo '#!/bin/bash \n source setenv \n lein repl :headless :host 0.0.0.0 :port $1' > repl && \
    chmod 755 setenv notebook lab repl

# run
WORKDIR /root
ENV LAB_PORT 54999
CMD lab $LAB_PORT

