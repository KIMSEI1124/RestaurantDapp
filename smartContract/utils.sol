// SPDX-License-Identifier: MIT
pragma solidity ^0.8.7;

contract utils {
    /**
     *  두개의 문자열을 비교하여 bool로 반환한다.
     *  string a : 문자열 a
     *  string b : 문자열 b
     *  return : 문자열이 동일하면 true, 동일하지 않으면 false를 반환한다.
     */
    function equals(string memory a, string memory b) public pure returns (bool) {
        if(bytes(a).length != bytes(b).length) {
            return false;
        } else {
            return keccak256(abi.encodePacked(a)) == keccak256(abi.encodePacked(b));
        }
    }
}