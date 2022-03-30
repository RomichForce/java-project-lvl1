run-dist:
	./build/install/app/bin/app

build-dist:
	./gradlew installDist

checkstyle:
	./gradlew checkstyleMain

build-run-dist: build-dist run-dist