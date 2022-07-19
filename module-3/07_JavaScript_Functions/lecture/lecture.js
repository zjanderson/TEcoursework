/**
 * All named functions will have the function keyword and
 * a name followed by parentheses.
 * 
 * @returns {number} 1
 */
function returnOne() {
  return 1;
}

/**
 * Functions can also take parameters. These are just variables that are filled
 * in by whoever is calling the function.
 *
 * Also, we don't *have* to return anything from the actual function.
 *
 * @param {any} value the value to print to the console
 */
function printToConsole(value) {
  console.log(value);
}

/**
 * Write a function called multiplyTogether that multiplies two numbers together. But 
 * what happens if we don't pass a value in? What happens if the value is not a number?
 *
 * @param {number} firstParameter the first parameter to multiply
 * @param {number} secondParameter the second parameter to multiply
 * @returns {number} result of these above being multiplied
 */

function multiplyTogether(firstParameter, secondParameter) {
  return firstParameter * secondParameter;
}

/**
 * This version makes sure that no parameters are ever missing. If
 * someone calls this function without parameters, we default the
 * values to 0. However, it is impossible in JavaScript to prevent
 * someone from calling this function with data that is not a number.
 * Call this function multiplyNoUndefined
 *
 * @param {number} [firstParameter=0] the first parameter to multiply
 * @param {number} [secondParameter=0] the second parameter to multiply
 */

function multiplyNoUndefined(firstParameter = 0, secondParameter = 0) {
  if(typeof firstParameter != 'number'){
    firstParameter = 0
  }
  return firstParameter * secondParameter;
}
 
/**
 * Functions can return earlier before the end of the function. This could be useful
 * in circumstances where you may not need to perform additional instructions or have to
 * handle a particular situation.
 * In this example, if the firstParameter is equal to 0, we return secondParameter times 2.
 * Observe what's printed to the console in both situations.
 * 
 * @param {number} firstParameter the first parameter
 * @param {number} secondParameter the second parameter
 */
function returnBeforeEnd(firstParameter, secondParameter) {
  console.log("This will always fire.");

  if (firstParameter == 0) {
    console.log("Returning secondParameter times two.");
    return secondParameter * 2;
  }

  //this only runs if firstParameter is NOT 0
  console.log("Returning firstParameter + secondParameter.");
  return firstParameter + secondParameter;
}

/**
 * Scope is defined as where a variable is available to be used.
 *
 * If a variable is declare inside of a block, it will only exist in
 * that block and any block underneath it. Once the block that the
 * variable was defined in ends, the variable disappears.
 */
function scopeTest() {
  // This variable will always be in scope in this function
  let inScopeInScopeTest = true;

  {
    // this variable lives inside this block and doesn't
    // exist outside of the block
    let scopedToBlock = inScopeInScopeTest;
  }

  // scopedToBlock doesn't exist here so an error will be thrown
  if (inScopeInScopeTest && scopedToBlock) {
    console.log("This won't print!");
  }
}

function createSentenceFromUser(name, age, listOfQuirks = [], separator = ', ') {
  let description = `${name} is currently ${age} years old. Their quirks are: `;
  return description + listOfQuirks.join(separator);
}

/* var hoisting */

/* arguments object and rest parameter syntax */

function usingExtraArgs(a, b, ...c) {
  console.log(a);
  console.log(b);
  console.log(c);
}

/* Named Functions: Regular vs. Arrow */

/* Anonymous functions */

/* Array functions requiring a function as a parameter */

/**
 * Takes an array and, using the power of anonymous functions, generates
 * their sum.
 *
 * @param {number[]} numbersToSum numbers to add up
 * @returns {number} sum of all the numbers
 * 
 * 
 */
function sumAllNumbers(numbersToSum) {
  return numbersToSum.reduce((prev, curr) => {
    return prev + curr;
  }, 0);
}

/**
 * Takes an array and returns a new array of only numbers that are
 * multiples of 3
 *
 * @param {number[]} numbersToFilter numbers to filter through
 * @returns {number[]} a new array with only those numbers that are
 * multiples of 3
 */
function allDivisibleByThree(numbersToFilter) {
  const filteredNumbers = [];

  for (num of numbersToFilter) {
    if (num % 3 === 0) {
      filteredNumbers.push(num);
    }
  }

  return filteredNumbers;
}

function isDivisibleByThree(num) {
  if (num % 3 === 0) {
    return true;
  }
  return false;
}

function allDivisibleByThree(numbersToFilter) {
  const filteredNumbers = numbersToFilter.filter(isDivisibleByThree);
  return filteredNumbers;
}

function allDivisibleByThree(numbersToFilter) {
  const filteredNumbers = numbersToFilter.filter(function(num){
  return num % 3 === 0;
})
}

/**
 * Return true if all numbers are divisible by 3
 *
 * @param {number[]} numbers numbers to filter through
 * @returns {boolean} true if all numbers are divisible by 3
 */
 function areAllDivisibleByThree(numbers) {
   return numbers.every(num => num % 3 === 0);

}


/**
 * Return an array of unique numbers. Try using .reduce()
 * 
 * @param {number[]} numbers array of numbers
 * @returns {number[]} an array of unique numbers
 */
function returnOneOfEach(numbers) {
  return numbers.reduce((prev, curr) => {
    if (!prev.includes(curr)){
      prev.push(curr);
    }
    return prev;
  }, []);
}

/**
 * Returns the longest string. Try using a traditional approach, and then
 * try using .reduce().
 * 
 * @param {string[]} strings an array of strings
 */
function returnLongestLength(strings) {
  if(strings && strings.length > 0) {
    let longestStr = strings[0];
    for(let i = 0; i < strings.length;, i++) {
      if(strings[i].length > longestStr.length) {
        longestStr = strings[i];
      }
    }
  }
  return longestStr;
}

function returnLongestLength(strings) {
  return strings.reduce((prev, curr) => {
    if(curr.length > prev.length) {
      return curr;
    }
    return prev;
  }, '');
}

/**
 * Takes an array of strings and returns true if any geese are 
 * masquerading as a duck.
 *
 * @param {string[]} ducks array of ducks
 * @returns {boolean} true if any object is a goose
 * 
 * ['duck', 'duck', 'duck'] => false
 * ['duck', 'goose', 'duck'] => true
 */
 function duckDuckGoose(ducks) {
   ducks.some(d => d ==='goose');
 }

 /**
 * Takes an array of numbers and formats them as money.
 *
 * @param {number[]} numbers array of numbers
 * @returns {number[]} an array of numbers formatted as currency $x.xx
 * 
 * 
 * [ 1, 5, 25.2 ] -> [ '$1.00', '$5.00', '$25.20' ]
 */
function toMoney(numbers) {
  const moneyNumbers = [];
  for (num of numbers) {
    moneyNumbers.push(`$${num.toFixed(2)}`);
  }
  return moneyNumbers;
}

function toMoney(numbers) {
  return numbers.map(num => { return `$${num.toFixed(2)}`});
}

/**
 * Takes an array of numbers, finds the numbers divisible by 3, doubles them,
 * and returns a new array as a result.
 * 
 * @param {number[]} numbers 
 * @returns {number[]} an array of numbers divisible by 3 doubled
 */
function methodChainingExample(numbers) {
  return numbers.filter(num => num % 3 === 0).map(num => num * 2);
}


function exampleOfFilterWithThreeParams(numbers) {
  numbers.filter((num, i, arr) => {
    console.log(`num: ${num}`);
    console.log(`i: ${i}`);
    console.log(`arr: ${arr}`);
    console.log();
  })
}