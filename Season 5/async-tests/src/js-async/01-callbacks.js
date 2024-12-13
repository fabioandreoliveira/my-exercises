/**
 * Invoke the callback and return the amount of time in miliseconds it took to execute
 */
exports.profileFunc = function (cb) {
    const start = performance.now();
    cb();
    const end = performance.now();
    return end - start;
    
};

/**
 * Invoke the async callback with the provided value after some delay
 */
exports.returnWithDelay = function (value, delay, cb) {
    setTimeout(cb, delay, null, value);
};
/**
 * Invoke the async callback with an error after some delay
 */
exports.failWithDelay = function (delay, cb) {
    setTimeout(cb, delay, new Error('fail'));
};

/**
 * Return a promise that resolves after the specified delay
 * or rejects if the delay is negative or non-existent
 */
exports.promiseBasedDelay = function (delay) {
    return new Promise((resolve, reject) => {
        if (delay < 0 || delay === undefined) {
            setTimeout(resolve, delay);
        } else {
            reject(new Error('fail'));
        }
    });
};
