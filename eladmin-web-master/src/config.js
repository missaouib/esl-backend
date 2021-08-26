const backendUri = process.env.VUE_APP_BASE_API || 'http://localhost:8000';
const wsBackendUri = process.env.VUE_APP_WS_API || 'wss://localhost:8000';
module.exports = {
    backendUri,
    wsBackendUri
};