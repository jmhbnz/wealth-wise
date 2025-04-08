# Wealth Wise Serverless Setup

## Prerequisites

### KNative CLI

Ensure you install the KNative CLI tool (KNative is the upstream open source project that OpenShift Serverless is derived from):

[KNative CLI Setup](https://knative.dev/docs/client/install-kn/)

### Quay.io Account

You will need a container registry to transfer serverless images to your OpenShift environment. Sign up at [quay.io](https://quay.io)

### Access to OpenShift

you will need access to an OpenShift cluster with sufficient resources, and the oc CLI tool to configure it. Ensure you're logged in to your OpenShift cluster with oc.





## Setting Up The Environment for Serverless

### Create a dedicated project for your serverless workloads

```sh
oc new-project wealthwise
```

### Create the OpenAI API Key Secret

```sh
oc create secret generic openai-token \
    --from-literal=OPENAI_API_KEY=<your-openai-key> -n wealthwise
```

TODO
TODO
TODO
### Create the PostGreSQL Credentials Secret

TODO
TODO
TODO

### Deploy the PostGreSQL Database

TODO
TODO
TODO


## Deploy the Serverless Components

### Deploy the backend functions

```sh
oc apply -f k8s-resources\\services\\financial-advisor-service.yaml
oc apply -f k8s-resources\\services\\investment-advisor-service.yaml
oc apply -f k8s-resources\\services\\advisor-history-service.yaml
```

### Deploy the frontend function
```sh
oc apply -f k8s-resources\\services\\frontend-service.yaml
```

### Get the route to the new application

Enjoy!
