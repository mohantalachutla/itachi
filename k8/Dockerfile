FROM node:14-alpine
# starting point of Dockerfile, downloads images from local, remote repositories
# Any docker image built from os level image like ubuntu, alpine(lightweight)
# node:alipine is same dowload alpine os and installing node on it
# 
# each line in Dockerfile runs as seperate layer in the container and hash it with SHA256, checks the SHA256SUM on each build for changes


WORKDIR /cryptofirst/server
#cd in the container # runs in the container
COPY ./package.json .
# copies host contents into working_dir od contaier # runs on the host
RUN npm install 
#SHELL FORM ONLY, creates a new shell # runs in the container
# mutiple run commands

COPY . .
EXPOSE 3000/tcp  
#exposes port on the contaner to outside but can not access with -p hostport:exposed port flag on the docker run
ENTRYPOINT [ "npm"] 
#EXECUTABLE FORM ONLY, won't create a new shell, can NOT be overrided by the commonds passed from cmd line # runs on the container
# only one ENTRYPOINT
CMD ["run", "start"]
#EXECUTABLE FORM ONLY, won't create a new shell, can be overrided by the commonds passed from cmd line,  # runs on the container
# only one CMD, last one will consided if many, appended to ENTRYPOINT if exists



#ARG    # to pass varible for build only
#ENV <KEY>:<VAL> # set environment varible
#VOLUME
#LABEL
#USER