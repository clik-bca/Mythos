#!/usr/bin/env bash
# Gradle Wrapper - Version 8.7

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
GRADLE_VERSION="8.7"

# Download gradle wrapper if not exists
if [ ! -f "$SCRIPT_DIR/gradle-wrapper.jar" ]; then
    echo "Gradle wrapper not found. Downloading..."
    mkdir -p "$SCRIPT_DIR/gradle"
    curl -fsSL "https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip" -o /tmp/gradle.zip
    unzip -q /tmp/gradle.zip -d "$SCRIPT_DIR/gradle"
    cp "$SCRIPT_DIR/gradle/gradle-${GRADLE_VERSION}/bin/gradle" "$SCRIPT_DIR/"
fi

export PATH="$SCRIPT_DIR/gradle/gradle-${GRADLE_VERSION}/bin:$PATH"
exec gradle "$@"