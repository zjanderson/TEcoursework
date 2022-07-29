<template>
  <div id="app">

    <div class="board">
      <div v-for="(guess, guessIndex) in guesses" :key="guessIndex" class="guess-row">
        <div v-bind:class="getClassName(guess, letterIndex)" v-bind:style="{ animationDelay: '' + (250 * letterIndex) + 'ms' }" v-for="(letter, letterIndex) in guess" :key="'' + guessIndex + letterIndex" class="guess-letter animated-guessed-letter">
            {{ letter }}
        </div>
      </div>

      <div id="" class="guess-row" v-if="guessesRemaining > 0">
        <div v-bind:class="{ 'animated-letter': currentGuess.length >= w }" v-for="w in WORD_LENGTH" :key="'current-guess-letter' + w" class="guess-letter">
          <div v-show="currentGuess.length >= w">
            {{ currentGuess[w - 1] }}
          </div>
        </div>
      </div>

      <div v-if="guessesRemaining === 0"></div>
      <div v-else v-for="g in guessesRemaining - 1" :key="'guess' + g" class="guess-row">
        <div v-for="w in WORD_LENGTH" :key="'guess' + g + '-guess-letter' + w" class="guess-letter">
        </div>
      </div>

    </div>

  </div>
</template>

<script>

export default {
  name: 'App',
  components: {
  },
  data() {
    return {
      WORD_LENGTH: 5,
      GUESS_COUNT: 6,
      word: 'apple',
      guesses: [],
      currentGuess: ''
    }
  },
  created() {
    document.addEventListener('keyup', (e) => this.onKeyUp(e.key));
  },

  computed: {
    guessesRemaining() {
      return this.GUESS_COUNT - this.guesses.length;
    }
  },

  methods: {
    onKeyUp(key) {
      if (key === 'Enter' && this.currentGuess.length === this.WORD_LENGTH) {
        // submit guess
        this.guesses.push(this.currentGuess);
        this.currentGuess = '';
      } else if (key === 'Backspace' && this.currentGuess.length > 0) {
        // remove last letter in guess
        this.currentGuess = this.currentGuess.substring(0, this.currentGuess.length - 1);
      } else if (key.length === 1 && key.match(/[a-zA-Z]/) && this.currentGuess.length < this.WORD_LENGTH) {
        // add letter
        this.currentGuess += key;
      }
    },

    getClassName(guess, letterIndex) {
      const guessedLetter = guess[letterIndex].toLowerCase();

      if (guessedLetter === this.word[letterIndex].toLowerCase()) {
        return 'correct';
      }

      for (let i = 0; i < this.word.length; i++) {
        if (i === letterIndex) continue;

        const currentWordLetter = this.word[i].toLowerCase();
        const currentGuessLetter = guess[i].toLowerCase();
        if (currentWordLetter === guessedLetter && currentWordLetter !== currentGuessLetter) {
          return 'includes';
        }
      }

      return 'incorrect';
    }
  }
}
</script>

<style>
  body {
    margin: 0;
  }

  #app {
    display: flex;
    align-items: center;
    justify-content: center;
    min-height: 100vh;
    font-family: "Clear Sans", "Helvetica Neue", Arial, sans-serif;
    font-weight: bold;
  }
  .board {
    width: 350px;
    height: 420px;
    display: grid;
    grid-template-rows: 1fr 1fr 1fr 1fr 1fr 1fr;
    gap: 5px;
  }

  .guess-row {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr 1fr 1fr;
    gap: 5px;
  }

  .guess-letter {
    border: 1px solid gray;
    line-height: 2rem;
    font-size: 2rem;
    text-transform: uppercase;
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .animated-letter {
    animation: pop-in .1s;
  }

  .animated-guessed-letter.correct {
    animation: flip-correct 1s forwards;
  }
  .animated-guessed-letter.includes {
    animation: flip-includes 1s forwards;
  }
  .animated-guessed-letter.incorrect {
    animation: flip-incorrect 1s forwards;
  }

  @keyframes pop-in {
    0% { opacity: 0; transform: scale(1.35); }
    100% { opacity: 1; transform: scale(1); }
  }

  @keyframes flip-correct {
    0% {
        transform: rotateX(0);
        background-color:white;
    }

    50% {
        transform: rotateX(90deg);
        background-color:white;
    }

    100% {
        transform: rotateX(0deg);
        background-color: #6aaa64;
        color: white;
        border: 0;

    }
  }
    @keyframes flip-includes {
    0% {
        transform: rotateX(0);
        background-color:white;
    }

    50% {
        transform: rotateX(90deg);
        background-color:white;
    }

    100% {
        transform: rotateX(0deg);
        background-color: #c9b458;
        color: white;
        border: 0;

    }
  }

    @keyframes flip-incorrect {
    0% {
        transform: rotateX(0);
        background-color:white;
    }

    50% {
        transform: rotateX(90deg);
        background-color:white;
    }

    100% {
        transform: rotateX(0deg);
        background-color: #86888a;
        color: white;
        border: 0;
    }
  }
</style>
