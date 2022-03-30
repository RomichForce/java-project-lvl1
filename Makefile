run-dist:
	./build/install/app/bin/app

build-dist:
	./gradlew installDist

build-run-dist: build-dist run-dist