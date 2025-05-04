#!/bin/bash
echo "Applying PostgreSQL YAML files..."
kubectl apply -f postgres-secret.yaml
kubectl apply -f postgres-deployment.yaml
kubectl apply -f postgres-service.yaml
echo "PostgreSQL configurations applied successfully." 