class string_compression(object):
    def compress(self, chars):
        """
        :type chars: List[str]
        :rtype: int
        """
        loc = 0
        cur_char = chars[0]
        count = 0
        for i, val in enumerate(chars):
            if cur_char == chars[i]:
                count = count + 1
            else:
                chars[loc] = cur_char
                loc = loc + 1
                if count != 1:
                    number_chars = list(str(count))
                    for num in number_chars:
                        chars[loc] = num
                        loc = loc + 1
                cur_char = chars[i]
                count = 1
        chars[loc] = cur_char
        loc = loc + 1
        if count != 1:
            number_chars = list(str(count))
            for num in number_chars:
                chars[loc] = num
                loc = loc + 1
        return loc