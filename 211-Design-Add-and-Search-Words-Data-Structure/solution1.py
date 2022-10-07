'''
The Basic Idea is Trie

The practical way is hashmap in hashmap

Overview:
Time: 5705ms (94.72%)
Memory: 56.4MB (74.2%)
'''
class WordDictionary:
    def __init__(self):
        self.d = {}

    def addWord(self, word: str) -> None:

        l = len(word)

        def addWord_node(node, i):
            if i < l:
                c = word[i]
                sub = node.get(c, {})
                addWord_node(sub, i + 1)
                node[c] = sub
            else:
                node['$'] = {}

        addWord_node(self.d, 0)

    def search(self, word: str) -> bool:

        l = len(word)

        def search_node(node, i):
            if i < l:
                c = word[i]
                if c == '.':
                    for key in node.keys():
                        if search_node(node[key], i + 1):
                            return True
                    return False
                if c in node:
                    return search_node(node[c], i + 1)
                else:
                    return False
            if '$' in node:
                return True

        return search_node(self.d, 0)

# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)