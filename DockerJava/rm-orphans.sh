#!/bin/sh

orphans=$(docker images -f "dangling=true" -q)

if [ -z "$orphans" ]
then
	echo "No orphan images."
	docker images
else
	echo "Removing orphan images:"
	docker rmi $(docker images -f "dangling=true" -q) --force
fi
